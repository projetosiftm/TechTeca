package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/Tech_Teca", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
