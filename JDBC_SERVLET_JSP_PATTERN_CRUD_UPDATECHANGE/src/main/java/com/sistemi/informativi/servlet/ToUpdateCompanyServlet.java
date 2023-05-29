package com.sistemi.informativi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dto.*;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;

@WebServlet("/toupdate")
public class ToUpdateCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Recuper delle informazioni di una riga della tabella di companies.jsp
		 in cui l'utente ha clickato update. Questi dati devono essere recuperati
		 esattamente nello stesso modo in cui erano presenti dalla pagina di
		 provenienza.*/
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		
		int intEmployeesNumber = Integer.parseInt(employeesNumber);
		CompanyDTO companyDTO = new CompanyDTO(vatNumber,businessName,addressLocation,intEmployeesNumber);
		
		if (companyDTO!=null) {
			/*Salviamo il DTO in sessione in maniera tale che
			 la jsp verrà caricata e possa caricare gli elementi
			 dal DTO e possa mostrarli precaricati nei campi della
			 pagina, così che l'utente possa modificarli.*/
			
			HttpSession session = request.getSession();
			session.setAttribute(Key.companyDTO, companyDTO);
			response.sendRedirect(Page.updateCompany);
			} else {
				response.sendRedirect(Page.error);
			}
	}
}
