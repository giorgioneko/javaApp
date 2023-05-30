package shoppingSystem;

public class DefaultUser implements User {
private static int userCounter = 0;
	private int id;
	private String name;
	private String lastname;
	private String Password;
	private String Email;
	
	{
		id = userCounter++;
	}
	
	public DefaultUser(String name,String lastName , String Password,String Email, String ConfirmPassword) throws Exception {
	if (Password.equals(ConfirmPassword)) {
	this.name = name;
	this.lastname = lastName;
	this.Password = Password;
	this.Email = Email;
	}
	else {
		throw new Exception("Confirm Password is not the same as password ");
	}
	
	}
	
	public String getFirstName() {
		return this.name;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public String getEmail(){
		return this.Email;
	}
	
	public void setEmail(String Email) {
		if (this.Email == null) {
			return;
		}
		this.Email = Email;
		
	}
	
	public void setPassword(String Password) {
	if (this.Password == null) {
		return;
	}
	this.Password = Password;
	}
	
	public String getPasswod() {
		return this.Password;
	}
	
	
	
	public int getId() {
		return this.id;
	}
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + "\t\t" +
				"Last Name: " + this.getLastName() + "\t\t" +
				"Email: " + this.getEmail();
	}
	
	void clearState() {
		userCounter = 0;
	}

	@Override
	public Boolean SamePassword(String password) {
		return this.Password.equals(password);
	}

	@Override
	public void addToDatabase(User user) {
		ApplicationContext context = ApplicationContext.getInstance();
		dataBaseConnection connection = context.getDataBaseConnection();
		connection.createNewData("account", "id,name,Email,Password,lastName", this.id+",'"+this.name+"','"+this.Email+"','"+this.Password+"','"+this.lastname+"'");
		
	}

	@Override
	public void editToDatabase(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFromDatabase(User user) {
		// TODO Auto-generated method stub
		
	}


	
	
}
