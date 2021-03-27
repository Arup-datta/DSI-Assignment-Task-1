package test;

import java.util.HashMap;
import java.util.ArrayList;

public class ProductList {
	///private ArrayList < Product > products = new ArrayList < Product > (); // Arraylist to contain products with information
	
	private HashMap <Integer, Product> products = new HashMap <Integer, Product > ();
	ProductList() {
		products.clear();
	}
	
	public void addProduct(int name, int buy, int sell, int availableNumber) {
		/// Adds new product to the product list
		
		Product newProduct = new Product(name, buy, sell, availableNumber);
		//products.add(newProduct);
		products.put(name, newProduct); /// name is the key
		
		System.out.println("Product is added to the list!");
	}
	

	
	public boolean searchProduct(int name) {
		/// check if a product already exists or not
		
		if(products.containsKey(name)) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	public void deleteProduct(int name) {
		// Deletes a product by searching it by name from the product list
		if(products.size() == 0) {
			System.out.println("Product list is already empty! Can't delete the product!");
			return;
		}
		if(products.containsKey(name)) {
			products.remove(name); // removes the product
			System.out.println("Product " + name + " is deleted!");
		}
		else {
			System.out.println("Product is not in the list! Can't delete!");
		}
	}
	
	
	public void buyProduct(int name, int count) {
		/// when a product is bought, the amount is added to the inventory
		
		Product p = products.get(name); // accessing the copy of that product
		p.addProduct(count); /// operating on that copy
		products.remove(name); /// remove and update the list
		products.put(name, p);
		int price = count * p.getBuyPrice(); // cost of the item 
		Balance.reduceBalance(price);// that cost is subtracted from the total balance
		System.out.println("Product is bought and added to the list!");
		
	}
	
	public void sellProduct(int name, int count) {
		
		Product p = products.get(name); /// taking a copy of that object
		if(count > p.getPiecesAvailable()) { 
			/// if there is not enough product to sell.. the we can't sell
			System.out.println("Not enough item to sell!\n");
			return;
		}
		int profit = (p.getSellPrice() - p.getBuyPrice()) * count; /// total profit
		p.sellProduct(count); // reducing the available number of products
		p.updateProfit(profit); /// updating profit value of that product
		Balance.addBalance(p.getSellPrice() * count); /// adding the selling price to the balance
		
		products.remove(name); /// updating the products map
		products.put(name, p);
		
		System.out.println("Product is sold!");
		
	}
	
	
	
	public void showProductList() {
		/// Function to print the entire product list
		for(int i : products.keySet()) {
			Product p = products.get(i);
			System.out.println("Product name: " + p.getProductName());
			System.out.println("Buying price: " + p.getBuyPrice());
			System.out.println("Selling price: " + p.getSellPrice());
			System.out.println("Available number in the inventory to sell : " + p.getPiecesAvailable());
			System.out.println("Total profit from that product: " + p.getProfit());
			System.out.println("");
		}
		
		
	}
	
}
