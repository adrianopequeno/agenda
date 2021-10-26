package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbagenda?usetimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	
	private Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
			return conn;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
	// testar conexao
	public void testeConnection() {
		try {
			Connection conn = conectar();
			System.out.println("OK!");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
}
