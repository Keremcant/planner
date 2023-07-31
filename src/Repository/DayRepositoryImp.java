package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helper.MysqlConnection;

public class DayRepositoryImp implements DayRepository {

	private Connection con;
	ResultSet rs = null;

	public DayRepositoryImp() {
		try {
			con = MysqlConnection.connMysql();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addDay(int date_id) throws SQLException {
		String query = "INSERT INTO day" + "(date_id) VALUES" + "(?)";
		PreparedStatement preparedStatement = this.con.prepareStatement(query);
		boolean key = false;

		try {

			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, date_id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (key)
			return true;
		else

			return false;
	}

	@Override
	public boolean dayCheck(int date_id) {

		String query = "SELECT * FROM day";
		boolean canLogin = false;

		try {
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				int dateid = rs.getInt("date_id");

				if (dateid == date_id) {
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
