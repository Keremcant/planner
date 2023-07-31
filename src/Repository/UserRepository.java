package Repository;

import java.sql.SQLException;

import Model.User;

public interface UserRepository {
	
	User getUserName(String name) throws SQLException;
	boolean getCheckPassword(String name, String password);

}
