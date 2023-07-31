package Repository;

import java.sql.SQLException;

public interface DayRepository{
	
	public boolean addDay(int date_id) throws SQLException;
	boolean dayCheck(int date_id);

}
