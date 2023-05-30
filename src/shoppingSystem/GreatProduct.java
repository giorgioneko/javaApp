package shoppingSystem;

public  class  GreatProduct extends DefaultProduct{

	
	public GreatProduct(int id, String productName, String categoryName, double price) {
		super(id,productName,categoryName,price);	
		
	}
	
	@Override
	public int getId() {
		return this.id;	
	}
	
	@Override
	public String getProductName() {
		return this.productName;
		
	}
	
	public double getPrice() {
		return this.price;
	}
	

}
