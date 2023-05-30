package shoppingSystem;

import java.util.List;

public interface Cart {
	boolean isEmpty();

	void addProduct(Product productById);

	List<Product> getProducts();
	void clear();
	
	void deleteProduct(Product productById);
	
	int getHowManySameProducts(Product current, List<Product> tempproducts);
		
	

}
