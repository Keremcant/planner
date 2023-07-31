package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
	
	private static MysqlConnection instant;
	
	private Connection c = null;
	
	private MysqlConnection() throws SQLException {
		this.c = DriverManager.getConnection("jdbc:MySql://localhost:3306/planner?user=root&password=12345678");
		
	}
	
	public static Connection connMysql() throws SQLException {
		if(instant == null) instant = new MysqlConnection();
		
		return instant.c;
	}

}
