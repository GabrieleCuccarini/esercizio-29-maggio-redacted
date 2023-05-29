package com.sistemi.informativi.script;

public interface SqlScript {

	final String sqlCompanyInsert = "insert into company (vat_number,business_name,"
			+ "address_location,employees_quantity) values (?,?,?,?)";
	
	final String sqlFindCompanies = "select * from company";
	
	final String sqlCompanyDelete = "delete from company where vat_number=?";
	
	final String sqlCompanyUpdate = "update company set business_name=?,address_location=?,employees_quantity=? WHERE vat_number=?";

}
