import java.sql.Connection;
import java.sql.SQLException;

import model.Estudiante;
import model.Matricula;

public class PruebaJDBC {

	public static void registrarJDBC() {
		System.out.println("-------- Prueba de Registro de Oracle JDBC ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("¡Oracle JDBC Driver no encontrado!");
			e.printStackTrace();
			return;

		}
		
		System.out.println("¡Oracle JDBC Driver Registrado!");
	}
	
	public static void main(String[] args) {
		registrarJDBC();
		
		Connection connection;
		ConexionOracle connectionMaker = new ConexionOracle();
		
		try {
			connection = connectionMaker.conectarConsultarBD();
			//connectionMaker.ExecuteStatement(connection);
			
			Matricula matricula = new Matricula();
			
			String response1 = matricula.dropTable(connection);
			System.out.println(response1);
			String response2 = matricula.createTable(connection);
			System.out.println(response2);
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo al conectar! Ver consola de salida");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("Conexión establecida");
		
	}
	
	

}
