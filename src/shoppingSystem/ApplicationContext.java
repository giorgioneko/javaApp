package shoppingSystem;

public class ApplicationContext {
	
	private static ApplicationContext instance;
	
	private User loggedInUser;
	private Cart sessionCart;
	private dataBaseConnection connection;
	
	
	
	private ApplicationContext() {
	}
	
	public void setLoggedInUser(User user) {
		if (this.sessionCart != null) {
			this.sessionCart.clear(); // we have to clear session cart when new user is logged in
		}
		this.loggedInUser = user;
	}
	
	public User getLoggedInUser() {
		return this.loggedInUser;
	}
	

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public Cart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return this.sessionCart;
	}
	
	public dataBaseConnection getDataBaseConnection() {
		if (this.connection == null) {
			this.connection = new dataBaseConnection();
			this.connection.getConnection();
		}
		return this.connection;
	}

}
