package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	
	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO contatos (nome,fone, email) VALUES (?,?,?)";
		
		try {
			// abre conexao com o bb
			Connection conn = conectar();
			// prepara a query de execução no banco
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	// testar conexao
	/*public void testeConnection() {
		try {
			Connection conn = conectar();
			System.out.println("OK!");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}*/
}
