package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sistemi.informativi.dao.*;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;
import com.sistemi.informativi.vo.*;
import com.sistemi.informativi.script.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CompanyVO> companies = new ArrayList<>();
		int nRows = 0;
		/*Recupero del valore assegnato al parametro vatNumber (corrispondente
		 al nome della variabile dopo il ? aggiunto all'url pattern delete della
		 richiesta proveniente dalla pagina companies.jsp*/
		String vatNumber = request.getParameter("vatNumber");
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		try {
			nRows = companyDAO.deleteCompany(SqlScript.sqlCompanyDelete, vatNumber);
			/*Dopo la cancellazione effettuiamo la lettura della tabella per far 
			 si che la pagina web, successivamente, possa visualizzare il corretto
			 stato del DB ATTUALE */
			companies = companyDAO.findAllCompanies(SqlScript.sqlFindCompanies);
			 //La lista companies riflette il contenuto della tabella DOPO IL DELETE
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		if (nRows > 0 && !companies.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			response.sendRedirect(Page.companies);
		} else {
			response.sendRedirect(Page.error);
		}
		return ;
	}

}