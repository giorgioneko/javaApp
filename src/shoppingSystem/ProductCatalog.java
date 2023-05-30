package shoppingSystem;


public class ProductCatalog  {

	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	public Product[] getProducts() {
		return  productManagementService.getProducts();
		
	}

	public Product fetchProduct(String userInput) {
		int productIdToAddToCart = Integer.parseInt(userInput);
		Product productToAddToCart = productManagementService.getProductById(productIdToAddToCart);
		return productToAddToCart;
	}

	public void processAddToCart(Product productToAddToCart) {
		context.getSessionCart().addProduct(productToAddToCart);
		System.out.println("Product %s has been added to your cart. " + productToAddToCart.getProductName());
	}
}
