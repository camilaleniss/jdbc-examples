package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reportes {

	public String ExecuteStatement(Connection con) throws SQLException {
		String result = "CODIGO_EST, NOMBRE_EST, NOMBRE_CURSO, HORARIO, SALON, NOMBRE_PROF \n";
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(
				"SELECT EST.COD_EST  AS \"COD_EST\", EST.NOMBRE AS \"NOMBRE_EST\", CUR.NOMBRE AS \"NOMBRE_CURSO\", CUR.HORARIO, CUR.SALON, PROF.NOMBRE AS \"NOMBRE_PROF\"\r\n" + 
				"FROM ESTUDIANTE EST, PROFESOR PROF, MATRICULA MAT, CURSO CUR\r\n" + 
				"WHERE MAT.ESTUDIANTE = EST.COD_EST \r\n" + 
				"    AND MAT.CURSO = CUR.COD_CURSO\r\n" + 
				"    AND CUR.PROFESOR = PROF.COD_PROF\r\n" + 
				"ORDER BY EST.NOMBRE");
		
		while (rs.next()) {
			String Cod = rs.getString("COD_EST");
			String NombreEstudiante = rs.getString("NOMBRE_EST");
			String NombreCurso = rs.getString("NOMBRE_CURSO");
			String Promedio = rs.getString("HORARIO");
			String Salon = rs.getString("SALON");
			String NombreProfesor = rs.getString("NOMBRE_PROF");
			result += Cod+", "+NombreEstudiante+", "+NombreCurso+", "+
			Promedio+", "+Salon +", "+NombreProfesor + "\n";
			}
		
		rs.close();
		stmt.close();
		return result;
	}
	
}
