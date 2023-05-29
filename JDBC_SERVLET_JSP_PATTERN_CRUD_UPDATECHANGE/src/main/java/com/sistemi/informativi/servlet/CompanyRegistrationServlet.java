package com.sistemi.informativi.servlet;

import com.sistemi.informativi.dao.*;
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sistemi.informativi.script.*;

//LA RIGA SOTTO SI DEFINISCE UN "METADATO"
@WebServlet("/registration")
public class CompanyRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nRows = 0;

		/*RECUPERO dei dati salvati nella richiesta HTTP da parte del client
		tradotto-->recupero il body della HttpRequest.
		Occore invocare ogni volta il metodo request.getParameter passando
		in input il name del campo html rappresentato dalla pagina web
		dalla quale viene inviata la richiesta*/
		//Poi si istanza una classe companyDAOImpl
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		int empIntNumber = Integer.parseInt(employeesNumber);
		CompanyDAO companyDAO = new CompanyDAOImpl();
		
		//Valorizzazione di oggetto DTO tramite le 
		//informazioni provenienti dal client
		CompanyDTO companyDTO = new CompanyDTO(vatNumber,businessName,addressLocation,empIntNumber);
		try {
			nRows = companyDAO.addCompany(SqlScript.sqlCompanyInsert, companyDTO);
			System.out.println(nRows);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//FINE FLUSSO DI RICHIESTA. INIZIO GESTIONE RISPOSTA
		if (nRows > 0) {			
			//Inizializzazione di Http Session
			HttpSession session = request.getSession();
			/*Per convenzione, se l'oggetto passato è X(companyDTO) 
			anche la chiave si passa come stringa analoga.
			Storage di una reference all'oggetto DTO che contiene tutte le
			informazioni inviate dal client in fase di richiesta, che 
			saranno così rese disponibili anche al flusso di risposta.
			Così successRegistration.jsp potrà recupere tutte le 
			informazioni necessarie per rispondere*/
			session.setAttribute(Key.companyDTO, companyDTO);
			response.sendRedirect(Page.successRegistration);
			/*La risposta dovrà contenere dati presenti nella richiesta
			Esempio = "Benvenuto utente.nome + utente.cognome"*/
		} else {
			response.sendRedirect(Page.error);
		}
	}

}
