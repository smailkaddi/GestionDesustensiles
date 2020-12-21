package GestionDesustensiles;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


public class Conection {

	Connection conn;
	Statement stat;
	ResultSet rs;
	
	public void Connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root" , "");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}

