package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement  st = null;
		ResultSet rs = null;
		
		try{
			
			conn = DB.getConnection(); // cria conexão
			
			st = conn.createStatement(); //cria um statement que retorna um objeto na forma de tabela
			
			rs = st.executeQuery("Select * from department"); // executa uma query 
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); // enquanto tiver linhas imprime os dados da coluna ID e Name
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
