package shoppingSystem;

import java.util.ArrayList;
import java.util.List;
public class DefaultCart implements Cart {

	private List<Product> products;
	
	{
		products = new ArrayList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return products.isEmpty();
	}

	@Override
	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		products.add(product);
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}
	
	

	@Override
	public void clear() {
		products.clear();
	}

	@Override
	public void deleteProduct(Product productById) {
		products.remove(productById);
		
	}

	@Override
	public int getHowManySameProducts(Product current,List<Product> tempproducts) {
		return current.getHowManySameProducts(current, tempproducts, this.products);
		
		
	}

}
