package shoppingSystem;

import java.util.List;

public class DefaultProduct implements Product {
	protected int id;
	protected String productName;
	protected String categoryName;
	protected double price;
	
	public DefaultProduct(int id, String productName, String categoryName, double price) {
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}
	
	
	public String toString() {
		return "Product id=" + id + ", product name=" + productName
				+ ", category name=" + categoryName + ", price=" + price;
	}
	@Override
	public double getProductPrice() {
		return this.price;
	}
	@Override
	public int getHowManySameProducts(Product current, List<Product> tempproducts, List<Product> currentProducts) {
		int total = 0;
		for (Product product : currentProducts) {
			if (product.getId() == current.getId()){
				if (total > 0) {
					tempproducts.remove(product);	
				}
				total++;
				
			}
			
		}
		return total;

	}

}
