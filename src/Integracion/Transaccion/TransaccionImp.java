/**
 * 
 */
package Integracion.Transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TransaccionImp implements Transaccion {

	
	private Connection connection;

	
	public void start() throws Exception {
		Class.forName("org.sqlite.JDBC");

		String url = "jdbc:sqlite:musicalia.db";
		connection = DriverManager.getConnection(url);
		connection.setAutoCommit(false);

		Statement stmt = connection.createStatement();
		stmt.execute("PRAGMA foreign_keys = ON");
		stmt.close();
	}

	
	public void commit()  {
		try {
		connection.commit();
		connection.close();
		} catch (SQLException e) {
			System.err.println("Error al hacer un commit sobre transaccion en curso: " + e.getMessage());
		}
	}

	
	public void rollback() throws SQLException {
		try {
		connection.rollback();
		connection.close();
		} catch (SQLException e) {
			System.err.println("Error al hacer un rollback sobre la transacción en curso: " + e.getMessage());
		}
	}

	
	public Object getResource() {
		return connection;
	}
}