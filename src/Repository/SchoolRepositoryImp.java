package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.MysqlConnection;

public class SchoolRepositoryImp implements SchoolRepository {
	
	private Connection con;

	public SchoolRepositoryImp() {
		try {
			con = MysqlConnection.connMysql();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean saveData(int day_id) throws SQLException {
		
		return false;
	}




	

}
