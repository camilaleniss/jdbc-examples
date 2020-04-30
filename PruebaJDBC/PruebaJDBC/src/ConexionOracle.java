import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionOracle {
	
	private String ip= "200.3.193.24";
	private String puerto= "1522";
	private String servicio = "ESTUD";
	
	private String username= "P09551_1_29";
	private String password= "rogelia123";
	
	/**
	* Se conecta a la base de datos del curso y ejecuta una consulta de prueba.
	* Luego imprime el resultado en la consola. Al final cierra la conexión.
	*
	* @param username el nombre de usuario
	* @param password la contraseña
	* @throws SQLException si ocurre un error al acceder a la BD
	*/
	public Connection conectarConsultarBD() throws SQLException {
			Connection con = DriverManager.getConnection(
					"jdbc:Oracle:thin:@//"+ip+":"+puerto+"/"+servicio,
					this.username,
					this.password);
			return con;
	}
	
	public void ExecuteStatement(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM Estudiante");
		
		while (rs.next()) {
			String Cod = rs.getString("COD_EST");
			String Nombre = rs.getString("NOMBRE");
			String Programa = rs.getString("NOMBRE_PROGRAMA");
			double Promedio = rs.getDouble("PROMEDIO_ACUMULADO");
			Date FechaNacimiento = rs.getDate("FECHA_NACIMIENTO");
			System.out.println(Cod+","+Nombre+","+Programa+", "+
			Promedio+", "+FechaNacimiento.toString());
			}
		
		con.close();
	}

}
