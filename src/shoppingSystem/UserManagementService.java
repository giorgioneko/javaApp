package shoppingSystem;

import java.sql.SQLException;

public interface UserManagementService {
	String registerUser(User user);
	User[] getUsers() throws SQLException, Exception;
	User getUserByEmail(String userEmail);

}
