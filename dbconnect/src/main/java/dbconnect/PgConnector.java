package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class PgConnector {
	private final String connectionUrl = "jdbc:postgresql://localhost:5432/test_db";
	private final String user_name = "postgres";
	private final String pwd = "int";

	public Connection getPgConnect() {
		Connection dbcon = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			dbcon = DriverManager.getConnection(connectionUrl, user_name, pwd);
			System.out.println("Baðlantý Saðlandý");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbcon;
	}

}
