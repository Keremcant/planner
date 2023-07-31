package Repository;

import java.sql.SQLException;

public interface SchoolRepository{
	
	boolean saveData(int day_id) throws SQLException;

}
