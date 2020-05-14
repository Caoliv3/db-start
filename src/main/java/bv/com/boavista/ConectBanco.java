package bv.com.boavista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLInput;

public class ConectBanco {
	
	private static final String SQL_INSERT = "insert into clientes(" +
	"id , nome ,  cpf, logradouro  ,numLogradouro  , cidade  ,estado  , status )" + 
	" VALUES (?,?,?,?,?,?,?,?)";
		
	private Connection con = null;
	java.sql.Statement sql = null;
	PreparedStatement sqlInsert = null;
		
	public ConectBanco() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			  con = DriverManager.getConnection("jdbc:sqlite:cadastro.db");
			  
			  sql = con.createStatement();
			  sql.executeUpdate("drop table if exists clientes");
			  sql.executeUpdate("create table clientes (id integer, nome string, cpf string ,logradouro string ,numLogradouro string , cidade string ,estado string , status string  )");
			  con.prepareStatement(SQL_INSERT);
		} catch (Exception e) {
			System.out.println("Erro ao processar dados" + e.getMessage());
		}
	}

	public void Insert(String b) {

		ModelCliente model = new ModelCliente(b);
		
		try {
			PreparedStatement sqlInsert = con.prepareStatement(SQL_INSERT);
			sqlInsert.setString(1, model.getId());
			sqlInsert.setString(2, model.getNome());
			sqlInsert.setString(3, model.getCpf());
			sqlInsert.setString(4, model.getLogradouro());
			sqlInsert.setString(5, model.getNumLogradouro());
			sqlInsert.setString(6, model.getCidade());
			sqlInsert.setString(7, model.getEstado());
			sqlInsert.setString(8, model.getStatus());
			
			sqlInsert.executeUpdate();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(con != null) {
			con.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar o banco" + e.getMessage());
		} 
	}
}