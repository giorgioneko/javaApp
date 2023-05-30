package shoppingSystem;

import java.util.Arrays;
import java.util.List;
public class DefaultUserManagementService implements UserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static final int DEFAULT_USERS_CAPACITY = 10;
	
	private static DefaultUserManagementService instance;
	
	private User[] users;
	private int lastUserIndex;
	
	{
		try {
			users = getUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private DefaultUserManagementService() {
	}
	
	@Override
	public String registerUser(User user) {
		if (user == null) {
			return NO_ERROR_MESSAGE;
		}
		
		String errorMessage = checkUniqueEmail(user.getEmail());
		if (errorMessage != null && !errorMessage.isEmpty()) {
			return errorMessage;
		}
		if (users != null && users.length != 0) {
		if (users.length <= lastUserIndex) {
			users = Arrays.copyOf(users, users.length << 1);
		}
		
		users[lastUserIndex++] = user;
		}
		user.addToDatabase(user);
		return NO_ERROR_MESSAGE;
	}

	private String checkUniqueEmail(String email) {
		if (email == null || email.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		if (users != null) {
		for (User user : users) {
			if (user != null && 
					user.getEmail() != null &&
					user.getEmail().equalsIgnoreCase(email)) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}
		
	}
		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	
	@Override
	public User[] getUsers() throws Exception {
		
		dataBaseConnection connection = ApplicationContext.getInstance().getDataBaseConnection();
		 List<String[]> data = connection.RetrieveData("account",5);
		 users = new User[data.size()];
		 int listLocation = 0;
		
		 for (String [] accountHolder : data) {
				int id = 	Integer.parseInt(accountHolder[0]);
				 String name = accountHolder[1];
					String Email = accountHolder[2];
					String password = accountHolder[3];
					String lastName = accountHolder[4] ;
					
					users[listLocation] = new DefaultUser(name, lastName,password,Email,password);
					listLocation++;
						
						
					}
		 return this.users;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User user : users) {
			if (user != null && user.getEmail().equalsIgnoreCase(userEmail)) {
				return user;
			}
		}
		return null;
	}
	
	void clearServiceState() {
		lastUserIndex = 0;
		users = new User[DEFAULT_USERS_CAPACITY];
	}
}