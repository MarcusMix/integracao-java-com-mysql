package projeto_banco_dados.projeto_teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BANCODADOS = "teste";
	private static final String CONEXAO = "jdbc:mysql://localhost:3306/" + BANCODADOS;
	private static final String USER = "root";
	private static final String PASSWORD = "admin";	
    public static void main( String[] args ) throws SQLException {
    	
    	Connection conexao = null;
        try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(CONEXAO, USER, PASSWORD);
			ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT  * FROM cliente"); 	
			System.out.println(conexao);
			while (rsCliente.next()) {
				System.out.println("ID: " + rsCliente.getInt("id"));
				System.out.println("Nome: " + rsCliente.getString("nome"));
				System.out.println("Idade: " + rsCliente.getInt("idade"));
				System.out.println("--------------");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Erro! Banco não localizado!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao acessar o banco!");
			e.printStackTrace();
		} finally {
			if(conexao != null) {
				conexao.close();
			}
		}
    }
}
