package com.sistemi.informativi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager implements DbParameters{
	
	//1) Questo metodo deve aprire una Connessione al DB e ritornarla
	static public Connection getConnection() throws ClassNotFoundException, SQLException {

		//Riga sotto si collega al DBMS
		Class.forName(dbDriver);
		
		return DriverManager.getConnection(dbUrl,dbUser,dbPass);
	};
	
	/*2) Inizializzazione di una variabile di tipo PreparedStatemente e ritorno
	di un Oggetto Prepared Statemente che potrà essere usato per un'operazione
	di insert oppure una operazione di update oppure una operazione di delete
	a seconda di quale sarà lo script sql che riceverà in input*/
	static public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		
		return getConnection().prepareStatement(sql);
	}
	
	/*3) Inizializzazione di una variabile di tipo ResultSet e ritorno
	 di una struttura dati che conterrà il risultato di una query
	 passatogli in input sotto forma di String sql dal metodo invocante*/
	static public ResultSet getResultSet(String sql) throws SQLException, ClassNotFoundException {
		
		Statement statement = getConnection().createStatement(); 
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
	//4 Chiusura della connessione e relativo check 
	static public void endConnection() throws ClassNotFoundException, SQLException {

		getConnection().close();
		
		if (!getConnection().isClosed()) {
			System.out.println("Connessione riuscita");
		} else {
			System.out.println("Connessione fallita");
		}
	}
	
}
