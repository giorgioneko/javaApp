package shoppingSystem;
import java.util.List;
import java.util.ArrayList;
public class DefaultOrder implements Order {
	public static int staticOrderid = 0;
	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private List<Product> products;
	private int customerId;
	private  int Orderid = 0;
	
	public DefaultOrder() {
		staticOrderid++;
		this.Orderid = staticOrderid;
		
	}

	@Override
	public boolean isCreditCardNumberValid(String userInput) {
	    if (!userInput.equals("")) {
		
	    	int sum = 0;
	    	boolean alternate = false;
	    	for (int i = userInput.length() - 1; i >= 0; i--) {
	    		int n = Integer.parseInt(userInput.substring(i, i + 1));
	    		if (alternate) {
	    			n *= 2;
	    			if (n > 9) {
	    				n = (n % 10) + 1;
	    			}
	    		}
	    		sum += n;
	    		alternate = !alternate;
	    	}
	    	return (sum % 10 == 0);
	    
	    }
	    
	    return false;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(List<Product> products) {
		this.products = new ArrayList<>(products);
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
					"credit card number - " + this.creditCardNumber + "\t" + 
					"products - " + this.products;
	}

	@Override
	public String  getCreditcardLast4Number() {
		int total = AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER - 4;
		String stars = "";
	while (total != 0) {
		stars = stars + "*";
		total--;
		
	}
		return stars + creditCardNumber.substring(creditCardNumber.length() - 4);
		
	}

	@Override
	public int getOrderId() {
		return this.Orderid;
		
	}
	
	@Override
	public int getHowManySameProducts(Product current,List<Product> tempproducts) {
		return current.getHowManySameProducts(current, tempproducts, this.products);
		
		
	}
	
	
	



	
	
	

}

