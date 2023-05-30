package shoppingSystem;

import java.sql.SQLException;

public class CustomerList  {

	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		ApplicationContext.getInstance();
	}
	
	
	public User[] getUsers() throws SQLException, Exception {
		User[] users = userManagementService.getUsers();
		
		if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers.");
			return null;
		} else {
	
			return users;
		}
	
	}


}
