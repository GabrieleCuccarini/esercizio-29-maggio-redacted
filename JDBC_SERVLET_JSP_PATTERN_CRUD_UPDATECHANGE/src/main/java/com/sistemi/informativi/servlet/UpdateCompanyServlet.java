package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import com.sistemi.informativi.dao.CompanyDAO;
import com.sistemi.informativi.vo.CompanyVO;
import com.sistemi.informativi.dao.CompanyDAOImpl;
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.page.Page;
import com.sistemi.informativi.script.SqlScript;

@WebServlet("/update")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nRows = 0;
		ArrayList<CompanyVO> companies = new ArrayList<>();
		/*Recupero del contenuto (eventualmente aggiornato) di una riga
		della tabella html nella pagina companies.jsp*/
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		int empIntNumber = Integer.parseInt(employeesNumber);
		
		//Valorizzazione di oggetto DTO tramite le informazioni provenienti dal client
		CompanyDTO companyDTO = new CompanyDTO(vatNumber,businessName,addressLocation,empIntNumber);
		
		CompanyDAO companyDAO = new CompanyDAOImpl();

		if (companyDTO!=null) {
			try {
				nRows = companyDAO.updateCompany(SqlScript.sqlCompanyUpdate, companyDTO);
				
				companies = companyDAO.findAllCompanies(SqlScript.sqlFindCompanies);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (nRows > 0 && !companies.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			response.sendRedirect(Page.companies);
		} else {
			response.sendRedirect(Page.error);
		}
	}

}