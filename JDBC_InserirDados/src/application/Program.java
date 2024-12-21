package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null; // permite montar a consulta SQL com os parâmetros para serem inseridos depois
		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"INSERT INTO seller" + "(Name, Email,BirthDate,BaseSalary,DepartmentId)" + "VALUES" + "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS); // o Return Generated Keys permite recuperar o ID do objeto inserido (nova linha)
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime())); // o Date capta apenas a data(sem horas
																					// e minutos) e a biblioteca usada
																					// para gravar dados no banco
																					// através dos JDBC é a java.sql,
																					// que é diferente da java.util)
			st.setDouble(4, 3000.00);
			st.setInt(5, 4);

			int rowsAffected = st.executeUpdate(); // atualiza banco
			System.out.println("Done! Rows Affected: " + rowsAffected);

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); // getGeneratedKey retorna objeto do tipo ResultSet("tabela")
				while (rs.next()) {
					int id = rs.getInt(1); // retorna valor da primeira coluna
					System.out.println("Done! Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ParseException e) {

			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}
}
