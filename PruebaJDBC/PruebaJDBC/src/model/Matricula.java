package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	private String insertIntoTable = "INSERT INTO MATRICULA (ESTUDIANTE, CURSO) VALUES(?, ?)";
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Matricula";
		}
		
		return "Successfully created table Matricula";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Matricula";
		}
		
		return "Successfully dropped table Matricula";
	}
			
	public String insertIntoTable(Connection connection, String estudiante, int curso) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertIntoTable);
			stmt.setString(1,estudiante);
			stmt.setInt(2, curso);
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return "Failed to insert row";
		}
		return "Succesfully inserted one row";
	}
	
}
