package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	/*
	 * Utilização de AutoCommit, Commit e RollBack para Garantir a integridade do
	 * Banco de dados (ACID). 1. Autocommit exige confirmação da operação
	 * manualmente 2. Commit Confirma que tudo ocorreu bem 3. Rollback, lançado na
	 * exceção para voltar o banco ao seu estado anterior
	 */

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();

			conn.setAutoCommit(false); // não confirma as operações automaticamente, ficam pendentes de uma confirmação explicita

			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentID = 1");

			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake Error");
			}

			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentID = 2");

			conn.commit(); // confirma de forma explicita que a transação terminou evitando inconsistência
							// de dados. Todo bloco entre o .setAutoCommit e .Commit esta protegido!

			System.out.println("Rows1 " + rows1);
			System.out.println("Rows1 " + rows2);

		} catch (SQLException e) {
			try {
				conn.rollback(); // Caso ocorra algum erro o banco de dados volta ao estado que era antes.
				throw new DbException("Transaction Rolled Back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error Trying to Rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}
}
