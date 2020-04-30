package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Profesor {

	private String createTableQuery = "CREATE TABLE PROFESOR(" + 
			"    COD_PROF varchar(10) NOT NULL," + 
			"    NOMBRE varchar(50) NOT NULL," + 
			"    DEPARTAMENTO number(3) NOT NULL, " + 
			"    PRIMARY KEY (COD_PROF)" + 
			")";
	
	private String dropTableQuery = "DROP TABLE PROFESOR";
	
	private String insertIntoTable = "INSERT INTO PROFESOR (COD_PROF, NOMBRE, DEPARTAMENTO) VALUES(?, ?, ?)";
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Profesor";
		}
		
		return "Successfully created table Profesor";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Profesor";
		}
		
		return "Successfully dropped table Profesor";
	}
	
	public String insertIntoTable(Connection connection, String cod_prof, String nombre, int departamento) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertIntoTable);
			stmt.setString(1, cod_prof);
			stmt.setString(2,nombre);
			stmt.setInt(3, departamento);
			stmt.executeUpdate();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return "Failed to insert row";
		}
		return "Succesfully inserted one row";
	}
	
}
