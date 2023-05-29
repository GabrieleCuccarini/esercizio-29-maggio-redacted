package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sistemi.informativi.dao.*;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;
import com.sistemi.informativi.script.SqlScript;
import com.sistemi.informativi.vo.*;

@WebServlet("/companies")
public class ViewCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewCompaniesServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<CompanyVO> companies = new ArrayList<>();
		CompanyDAO companyDAO = new CompanyDAOImpl();
		try {
			/*Recupero di tutte le company esistenti attualmente sul DB grazie
			 all'invocazione del metodo del DAO findAllCompanies*/
			companies = companyDAO.findAllCompanies(SqlScript.sqlFindCompanies);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//FINE FLUSSO DI RICHIESTA. INIZIO GESTIONE RISPOSTA
		if (!companies.isEmpty()) {			
			/*Inizializzazione di Http Session e salvataggio nella
			sessione dell'ArrayList restituida dallo strato DAO solo
			se l'ArrayList contiene informazioni !companies.isEmpty()*/
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			//Redirect a Viw delle companies
			response.sendRedirect(Page.companies);
		} else {
			response.sendRedirect(Page.error);
		}
	}

}
