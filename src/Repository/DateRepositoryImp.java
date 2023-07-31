package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.MysqlConnection;
import Model.Date;

public class DateRepositoryImp implements DateRepository {

	private Connection con;

	public DateRepositoryImp() {
		try {
			con = MysqlConnection.connMysql();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Date> getList() throws SQLException {
		ArrayList<Date> list = new ArrayList<>();
		Statement st = this.con.createStatement();
		ResultSet rs = null;
		Date obj;
		try {
			st = this.con.createStatement();
			rs = st.executeQuery("SELECT * FROM sdate");
			while (rs.next()) {
				obj = new Date();
				obj.setId(rs.getInt("id"));
				obj.setDate(rs.getString("date"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
		}
		return list;
	}

	@Override
	public boolean addDate(String date) throws SQLException {
		int count = 0;
		Statement st = this.con.createStatement();
		ResultSet rs = null;
		String query = "INSERT INTO sdate " + "(date) VALUES" + "(?)";
		PreparedStatement preparedStatement = this.con.prepareStatement(query);
		int key = 0;
		try {
			rs = st.executeQuery("SELECT * FROM sdate WHERE status='a' AND date = '" + date + "'");
			while (rs.next()) {
				count++;
				break;
			}
			if (count == 0) {
				preparedStatement = this.con.prepareStatement(query);
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, date);
				preparedStatement.execute();
			}
			key = 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (key == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteDate(int id) throws SQLException {

		String query = "DELETE FROM sdate WHERE id=?";
		PreparedStatement preparedStatement = this.con.prepareStatement(query);
		boolean key = false;
		try {
			preparedStatement = this.con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateDate(int id, String date) {
		String query = "UPDATE sdate SET date = ? WHERE id = ?";
		boolean key = false;
		try {
			PreparedStatement preparedStatement = this.con.prepareStatement(query);
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, date);
			preparedStatement.execute();
			key = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

}
