package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Matricula {
	
	private String createTableQuery = "CREATE TABLE MATRICULA(\r\n" + 
			"    ESTUDIANTE varchar(12) NOT NULL,\r\n" + 
			"    CURSO number(12) NOT NULL,\r\n" + 
			"    FOREIGN KEY (ESTUDIANTE) REFERENCES ESTUDIANTE(COD_EST),\r\n" + 
			"    FOREIGN KEY (CURSO) REFERENCES CURSO(COD_CURSO)\r\n" + 
			")";
	
	private String dropTableQuery = "DROP TABLE MATRICULA";
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Matricula";
		}
		
		return "Successful created table Matricula";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Matricula";
		}
		
		return "Successful dropped table Matricula";
	}
			
}
