package fr.isty.iatic5.archilog.sessions.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@Configuration
public class SqlUtils {
	private static Connection conn = null;
	private static String url = "jdbc:sqlite:data.db";

	//@Bean
	public static void connect() {
		try {

			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println("probleme de connexion sur sqlite : "+ e.getMessage());
		}
	}

	public static ResultSet requestSelect(String sql) {
		ResultSet rs = null;
		try {
			// conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	public static int requestUpdate(String sql) {
		int rs = 0;
		try {
			// conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	public static void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

