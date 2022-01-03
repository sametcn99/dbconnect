package dbconnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCalisanList {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PgConnector pgc = new PgConnector();
		Connection con = pgc.getPgConnect();

		String query = "SELECT id, ad, soyad, adres, ucret FROM calisan";
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String adres = rs.getString("adres");
				float ucret = rs.getFloat("ucret");
				System.out.println(id + "," + ad + "," + soyad + "," + adres + "," + ucret);
			}

		} catch (Exception e) {
			System.out.println("" + e);
		}

	}

}
