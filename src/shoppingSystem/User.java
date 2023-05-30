package shoppingSystem;

public interface User {
	String getFirstName();
	String getLastName();
	Boolean SamePassword(String password);
	String getEmail();
	int getId();
	void setPassword(String newPassword);
	void setEmail(String newEmail);
	void addToDatabase(User user);
	void editToDatabase(User user);
	void deleteFromDatabase(User user);

}
