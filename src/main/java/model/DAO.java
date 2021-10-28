package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<JavaBeans> listarContato() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String read = "SELECT * FROM contatos ORDER BY nome";
		
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Integer idcon = Integer.parseInt(rs.getString(1).toString());
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			
			conn.close();
			
			return contatos;
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			return null;
		}
	}
	
	public void selecionarContato(JavaBeans contato) {
		String read = "SELECT * FROM contatos WHERE idcon = ?";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setInt(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				// setar as variaveis JavaBeans
				contato.setIdcon(rs.getInt(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void alterarContato(JavaBeans contato) {
		String create = "UPDATE contatos SET nome=?, fone=?, email=? WHERE idcon=?";
		
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon().toString());
			pst.executeUpdate();
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
