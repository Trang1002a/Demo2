package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static Connection openDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH", "sa", "1234$");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
