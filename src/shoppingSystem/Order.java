package shoppingSystem;

import java.util.List;

public interface Order {
	
	boolean isCreditCardNumberValid(String userInput);
	
	void setCreditCardNumber(String userInput);
	
	void setProducts(List<Product> list);
	
	void setCustomerId(int customerId);
	
	int getCustomerId();
	String getCreditcardLast4Number();
	
	List<Product> getProducts();
	
	int getOrderId();

	int getHowManySameProducts(Product current, List<Product> tempproducts);


}
