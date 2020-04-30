import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import model.Curso;
import model.Estudiante;
import model.Matricula;
import model.Profesor;
import model.Reportes;

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
			
			/*
			 * Si se elimina de comentarios la siguiente línea de código, es necesario hacer commits explícitos
			 * haciendo uso de las líneas 87, 105, 117 y 144.
			 * Hacer los commits no es necesario pues todas las conexiones abiertas tiene definido la
			 * característica de auto-commits por defecto cómo true.
			 */
			//connection.setAutoCommit(false);
			
			Matricula matricula = new Matricula();
			Curso curso = new Curso();
			Profesor profesor = new Profesor();
			Estudiante estudiante = new Estudiante();
			Reportes reporte = new Reportes();
			
			System.out.println("Eliminación de tablas:");
			System.out.println(matricula.dropTable(connection));
			System.out.println(curso.dropTable(connection));
			System.out.println(profesor.dropTable(connection));
			System.out.println(estudiante.dropTable(connection));
			System.out.println();
			
			System.out.println("Creación de tablas:");
			System.out.println(estudiante.createTable(connection));
			System.out.println(profesor.createTable(connection));
			System.out.println(curso.createTable(connection));
			System.out.println(matricula.createTable(connection));
			System.out.println();
			
			System.out.println("Inserción de tuplas:");
			System.out.println("Tabla estudiante:");
			System.out.println(estudiante.insertIntoTable(connection, "051135593", "Sofia Loren", "Ciencia Politica", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "060839453", "Julio Iglesias", "Diseno Industrial", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "099354543", "Andres Cepeda", "Derecho", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "112348546", "Julio Sabala ", "Ingenieria de sistemas", 4.0, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "115987938", "Fernando Alonso", "Ingenieria de sistemas", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "132977562", "Celia Cruz", "Antropologia", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "269734834", "Placido Domingo", "Psicologia", 4.0, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "280158572", "Angela Carrasco", "Medicina", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "125465152", "Richard Marx", "Psicologia", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "879654165", "Luis Angel", "Economia", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "894165418", "David Copperfield", "Ingenieria telematica", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "845544524", "Camilo Torres ", "Ingenieria de sistemas", 4.0, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "225485661", "Arcipreste de Hita", "Ingenieria de sistemas", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "236978745", "William Wallace", "Contaduria y finanzas", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "158965874", "Jaime Lannister", "Economia", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "174875888", "Juan Sin Tierra", "Ingenieria telematica", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "744548788", "Alejandro Magno", "Ingenieria industrial", 4.0, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "799895959", "Charles Darwin", "Administracion", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "848984115", "Fabiana Cantilo", "Ingenieria de sistemas", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "998745556", "Andres Calamaro", "Ingenieria industrial", 4.2, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "887554633", "Steven Tyler", "Ingenieria de sistemas", 3.5, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "326659989", "Cristiano Ronaldo", "Medicina", 4.0, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "357485638", "Juan Pablo Montoya", "Economia", 3.7, Date.valueOf("2000-09-08")));
			System.out.println(estudiante.insertIntoTable(connection, "321456322", "Antonio Ricaurte", "Medicina", 4.2, Date.valueOf("2000-09-08")));
			//connection.commit();
			
			System.out.println("Tabla Profesor:");
			System.out.println(profesor.insertIntoTable(connection,"142519864", "Andres Aristizabal", 20));
			System.out.println(profesor.insertIntoTable(connection,"228494949", "Luis Felipe Cardona", 68));
			System.out.println(profesor.insertIntoTable(connection,"142577888", "Hugo Arboleda", 20));
			System.out.println(profesor.insertIntoTable(connection,"987588857", "Gonzalo Llano", 68));
			System.out.println(profesor.insertIntoTable(connection,"214587588", "Angela Villota", 68));
			System.out.println(profesor.insertIntoTable(connection,"159848999", "Gabriel Tamura", 12));
			System.out.println(profesor.insertIntoTable(connection,"852698458", "Sandra Cespedes", 20));
			System.out.println(profesor.insertIntoTable(connection,"875151155", "Norha Villegas", 12));
			System.out.println(profesor.insertIntoTable(connection,"898465166", "Alvaro Pachon", 12));
			System.out.println(profesor.insertIntoTable(connection,"898456515", "Luis Eduardo Munera", 33));
			System.out.println(profesor.insertIntoTable(connection,"251651512", "Carlos Arce", 11));
			System.out.println(profesor.insertIntoTable(connection,"454515612", "Juan Carlos Muñoz", 20));
			System.out.println(profesor.insertIntoTable(connection,"125465151", "Andrés Navarro", 11));
			System.out.println(profesor.insertIntoTable(connection,"151616152", "Alfonso Bustamante", 33));
			System.out.println(profesor.insertIntoTable(connection,"784156145", "Gonzalo Ulloa", 20));
			//connection.commit();
			
			System.out.println("Tabla Curso");
			System.out.println(curso.insertIntoTable(connection, 1, "Algoritmos y estructuras de datos", "LUN-MIE-VIE 11-13", "208C", "142519864"));
			System.out.println(curso.insertIntoTable(connection, 2, "Algebra y funciones", "LUN-MIE-VIE 11-13", "208C", "142577888"));
			System.out.println(curso.insertIntoTable(connection, 3, "Principios de economia", "LUN-MIE-VIE 11-13", "208C", "214587588"));
			System.out.println(curso.insertIntoTable(connection, 4, "Fundamentos de derecho", "LUN-MIE-VIE 11-13", "208C", "251651512"));
			System.out.println(curso.insertIntoTable(connection, 5, "Arquitectura de software", "LUN-MIE-VIE 11-13", "208C", "159848999"));
			System.out.println(curso.insertIntoTable(connection, 6, "Ingeniería de software", "LUN-MIE-VIE 11-13", "208C", "875151155"));
			System.out.println(curso.insertIntoTable(connection, 7, "COE I", "LUN-MIE-VIE 11-13", "208C", "125465151"));
			System.out.println(curso.insertIntoTable(connection, 8, "COE II", "LUN-MIE-VIE 11-13", "208C", "151616152"));
			System.out.println(curso.insertIntoTable(connection, 9, "Bases de datos", "LUN-MIE-VIE 11-13", "208C", "142519864"));
			//connection.commit();
			
			System.out.println("Tabla Matricula:");
			System.out.println(matricula.insertIntoTable(connection, "051135593", 1));
			System.out.println(matricula.insertIntoTable(connection, "060839453", 2));
			System.out.println(matricula.insertIntoTable(connection, "099354543", 3));
			System.out.println(matricula.insertIntoTable(connection, "112348546", 4));
			System.out.println(matricula.insertIntoTable(connection, "115987938", 5 ));
			System.out.println(matricula.insertIntoTable(connection, "132977562", 6));
			System.out.println(matricula.insertIntoTable(connection, "269734834", 7));
			System.out.println(matricula.insertIntoTable(connection, "280158572", 8));
			System.out.println(matricula.insertIntoTable(connection, "125465152", 9));
			System.out.println(matricula.insertIntoTable(connection, "879654165", 1));
			System.out.println(matricula.insertIntoTable(connection, "894165418", 2));
			System.out.println(matricula.insertIntoTable(connection, "845544524", 3 ));
			System.out.println(matricula.insertIntoTable(connection, "225485661", 4));
			System.out.println(matricula.insertIntoTable(connection, "236978745", 5));
			System.out.println(matricula.insertIntoTable(connection, "158965874", 6));
			System.out.println(matricula.insertIntoTable(connection, "174875888", 7));
			System.out.println(matricula.insertIntoTable(connection, "744548788", 8));
			System.out.println(matricula.insertIntoTable(connection, "799895959", 9));
			System.out.println(matricula.insertIntoTable(connection, "848984115", 1));
			System.out.println(matricula.insertIntoTable(connection, "998745556", 2));
			System.out.println(matricula.insertIntoTable(connection, "887554633", 3 ));
			System.out.println(matricula.insertIntoTable(connection, "326659989", 4));
			System.out.println(matricula.insertIntoTable(connection, "357485638", 5));
			System.out.println(matricula.insertIntoTable(connection, "321456322", 6));
			//connection.commit();
			
			System.out.println("********** INICIO REPORTE DE CURSOS POR ESTUDIANTE **********");
			System.out.println(reporte.ExecuteStatement(connection));
			System.out.println("********************* FIN REPORTE **************************");
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo al conectar! Ver consola de salida");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
