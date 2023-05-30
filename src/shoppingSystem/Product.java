package shoppingSystem;

import java.util.List;

public interface Product {
	int getId();
	String getProductName();
	double getProductPrice();
	public int getHowManySameProducts(Product current,List<Product> tempproducts,List<Product> currentProducts);

}
