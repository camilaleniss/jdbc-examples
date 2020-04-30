package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Estudiante {
	
	private String createTableQuery = "CREATE TABLE ESTUDIANTE(" + 
			"    COD_EST varchar(12) NOT NULL," + 
			"    NOMBRE varchar(50) NOT NULL," + 
			"    NOMBRE_PROGRAMA varchar(50) NOT NULL, " + 
			"    PROMEDIO_ACUMULADO number(2,1), " + 
			"    FECHA_NACIMIENTO DATE," + 
			"    PRIMARY KEY (COD_EST)" + 
			")";
	
	private String dropTableQuery = "DROP TABLE ESTUDIANTE";
	
	private String insertIntoTable = "INSERT INTO CURSO (COD_EST, NOMBRE, NOMBRE_PROGRAMA, PROMEDIO_ACUMULADO, FECHA_NACIMIENTO) VALUES(?, ?, ?, ?, ?)";
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Estudiante";
		}
		
		return "Successfully created table Estudiante";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Estudiante";
		}
		
		return "Successfully dropped table Estudiante";
	}
	
	public String insertIntoTable(Connection connection, int cod_est, String nombre, String nombrePrograma, double promedioAcumulado, Date fechaNac) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertIntoTable);
			stmt.setInt(1, cod_est);
			stmt.setString(2, nombre);
			stmt.setString(3, nombrePrograma);
			stmt.setDouble(4, promedioAcumulado);
			stmt.setDate(5, fechaNac);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return "Failed to insert row";
		}
		return "Succesfully inserted one row";
	}
	
}
