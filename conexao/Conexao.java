package br.com.rafael.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Conexao() {
		
	}
	
	public static Connection conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaquinta", "root", "");
		return con;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection c = conectar();
		System.out.println(c);

	}

}
