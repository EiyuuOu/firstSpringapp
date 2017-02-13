package firstSpringApp.repository;

import java.util.ArrayList;
import java.util.List;

import firstSpringApp.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
	
	private List<Product> products;
	
	public ProductRepositoryImpl(){
		System.out.println("Hello From Product Constructor!");
		this.products = new ArrayList<Product>();
	}
	
	/* (non-Javadoc)
	 * @see firstSpringApp.repository.ProductRepository#getProducts()
	 */
	@Override
	public List<Product> getProducts(){
		Product product1 = new Product("1984", "Orwell", "Book", 9.99);
		Product product2 = new Product("Brave New World", "Iron Maiden", "CD", 12.99);
		Product product3 = new Product("For whom the bell tolls", "Hemingway", "Book", 8.99);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		return products;	
	}
	

}
