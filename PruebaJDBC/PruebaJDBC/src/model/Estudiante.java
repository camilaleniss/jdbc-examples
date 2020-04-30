package model;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Estudiante";
		}
		
		return "Successful created table Estudiante";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Estudiante";
		}
		
		return "Successful dropped table Estudiante";
	}
			
}
