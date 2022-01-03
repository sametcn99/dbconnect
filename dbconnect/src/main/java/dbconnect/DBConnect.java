package dbconnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DBConnect extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection c = null;
		Statement stmt = null;
		try {
			String id = req.getParameter("id");
			String adi = req.getParameter("ad");
			String soyadi = req.getParameter("soyad");
			String yasi = req.getParameter("yas");
			String adresi = req.getParameter("adres");
			String ucreti = req.getParameter("ucret");
			System.out.println(id + adi + soyadi + yasi + adresi + ucreti);
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_db", "postgres", "int");
			c.setAutoCommit(false);
			System.out.println("Baglanti Basarili");
			stmt = c.createStatement();
			// String sql="CREATE TABLE CALISAN (ID INTEGER PRIMARY KEY NOT NULL, AD TEXT
			// NOT NULL,SOYAD TEXT NOT NULL,YAS INT NOT NULL,ADRES CHAR(50),UCRET REAL)";
			String sql = "INSERT INTO public.calisan(id, ad, soyad, yas, adres, ucret) VALUES (" + id + ", '" + adi
					+ "', '" + soyadi + "', " + yasi + ", '" + adresi + "', " + ucreti + ");";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			c.commit();
			c.close();
		} catch (Exception e) {
			System.out.print(e.getClass().getName() + " " + e.getMessage());
		}
	}
}