package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Curso {

	private String createTableQuery = "CREATE TABLE CURSO(" + 
			"    COD_CURSO number(12) NOT NULL," + 
			"    NOMBRE varchar(50) NOT NULL," + 
			"    HORARIO varchar(50) NOT NULL, " + 
			"    SALON varchar(20) NOT NULL, " + 
			"	 PROFESOR number(12) NOT NULL,"+
			"    PRIMARY KEY (COD_CURSO)," + 
			"    FOREIGN KEY (PROFESOR) REFERENCES PROFESOR(COD_PROF)" + 
			")";
	
	private String dropTableQuery = "DROP TABLE ESTUDIANTE";
	
	private String insertIntoTable = "INSERT INTO CURSO (COD_CURSO, NOMBRE, HORARIO, SALON, PROFESOR) VALUES(?, ?, ?, ?, ?)";
	
	public String createTable(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(createTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed create table Curso";
		}
		
		return "Successfully created table Curso";
		
	}
	
	public String dropTable(Connection connection) {
		try {
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(dropTableQuery);
		}catch (SQLException e) {
			e.printStackTrace();
			return "Failed drop table Curso";
		}
		
		return "Successfully dropped table Curso";
	}
	
	
	public String insertIntoTable(Connection connection, int cod_curso, String nombre, String horario, String salon, int profesor) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertIntoTable);
			stmt.setInt(1, cod_curso);
			stmt.setString(2,nombre);
			stmt.setString(3, horario);
			stmt.setString(4, salon);
			stmt.setInt(5, profesor);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return "Failed to insert row";
		}
		return "Succesfully inserted one row";
	}
	
}
