package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.MysqlConnection;
import Model.User;

public class UserRepositoryImp implements UserRepository{
	
	private Connection con;
	
	public UserRepositoryImp() {
		try {
			con = MysqlConnection.connMysql();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User getUserName(String name) throws SQLException {
		
		String query = "select * from user where name = ?";
		PreparedStatement ps = this.con.prepareStatement(query);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		return user;

		
}

	@Override
	public boolean getCheckPassword(String name, String password) {
		String query = "select * from user";
		boolean canLogin = false;
		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String userName = rs.getString("name");
				String userPass = rs.getString("password");
				if(userName.equals(name) && userPass.equals(password)) {
					canLogin = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return canLogin;
	}
	
	}
