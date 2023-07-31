package Repository;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Date;

public interface DateRepository {

	ArrayList<Date> getList() throws SQLException;


	boolean addDate(String date) throws SQLException;

	boolean deleteDate(int id) throws SQLException;

	boolean updateDate(int id, String date);

}
