package test;

import java.util.HashMap;
import java.util.ArrayList;

public class ProductList {
	private ArrayList < Product > products = new ArrayList < Product > (); // Arraylist to contain products with information
	
	ProductList() {
		products.clear();
	}
	
	public void addProduct(String name, int buy, int sell, int availableNumber) {
		/// Adds new product to the product list
		
		Product newProduct = new Product(name, buy, sell, availableNumber);
		products.add(newProduct);
	}
	
	/*public void updateProduct(String name, int number) {
		/// Updates the available number for sell from the inventory
		
		for(int i = 0 ; i < products.size(); ++i) {
			Product p = products.get(i);
			if(p.getProductName().equals(name)) {
				p.addProduct(number);
				products.set(i, p);
				break;
			}
		}
	}
	*/
	
	public boolean searchProduct(String name) {
		/// check if a product already exists or not
		
		for(int i = 0 ; i < products.size(); ++i) {
			Product p = products.get(i);
			if(p.getProductName().equals(name)) {
				return true;
			}
		}
		return false;
	} 
	
	public void deleteProduct(String name) {
		// Deletes a product by searching it by name from the product list
		if(products.size() == 0) {
			System.out.println("Product list is already empty! Can't delete the product!");
			return;
		}
		int index = -1;
		for(int i = 0 ; i < products.size(); i++) {
			Product p = products.get(i);
			String productName = p.getProductName();
			if(productName.equals(name)) {
				index = i;
				break;
			}
		}
		if(index != -1) {
			products.remove(index); /// remote that specific product
			System.out.println("Product " + name + " is deleted!");
		}
		else {
			System.out.println("Product is not in the list!");
		}
	}
	
	
	public void buyProduct(String name, int count) {
		/// when a product is bought, the amount is added to the inventory
		for(int i = 0 ; i < products.size() ; ++i) {
			Product p = products.get(i);
			if(p.getProductName().equals(name)) {
				p.addProduct(count); /// adding instances to the existing product
				products.set(i, p); /// updating the product list
				
				int price = count * p.getBuyPrice(); // cost of the item 
				Balance.reduceBalance(price);// that cost is subtracted from the total balance
				System.out.println("Product is bought and added to the list!");
				break;
			}
		}
	}
	
	public void sellProduct(String name, int count) {
		for(int i = 0 ; i < products.size() ; ++i) {
			Product p = products.get(i);
			if(p.getProductName().equals(name)) { /// searching for that product
				if(count > p.piecesAvailable()) { 
					/// if there is not enough product to sell.. the we can't sell
					System.out.println("Not enough item to sell!\n");
					break;
				}
				int profit = (p.getSellPrice() - p.getBuyPrice()) * count; /// total profit
				p.sellProduct(count); // reducing the available number of products
				p.updateProfit(profit); /// updating profit value of that product
				Balance.addBalance(p.getSellPrice() * count); /// adding the selling price to the balance
				products.set(i, p); // updating product list
				System.out.println("Product is sold!");
				break;
			}
		}
	}
	
	
	
	public void showProductList() {
		/// Function to print the entire product list
		
		for(int i = 0 ; i < products.size() ; ++i) {
			Product product = products.get(i);
			HashMap < String,String > values = product.productInfo(); /// get product information
			System.out.println("Product number: " + (i + 1));
			System.out.println("Product Name: " + values.get("Name"));
			System.out.println("Buy Price: " + values.get("Buy"));
			System.out.println("Sell Price: " + values.get("Sell"));
			System.out.println("Available number in the inventory: " + values.get("Count"));
			System.out.println("Profit form " + values.get("Name") + ": " + values.get("Profit"));
			System.out.println("");
		}
		
	}
	
}
