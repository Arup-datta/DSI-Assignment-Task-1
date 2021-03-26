package test;
import java.util.*;
import java.util.HashMap;


public class Product {
	private int name, buyPrice, sellPrice, availablePieces, profit;

	Product(int name, int buyPrice, int sellPrice, int availablePieces) {
		/// constructor to set product information
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.name = name;
		this.availablePieces = availablePieces;
		profit = 0; // when a product is created, total profit form this product is zero
	}
	
	
	public void setProfit(int value) {
		/// updates profit when we sell an item
		
		profit += value;
	}
	
	public int getBuyPrice() {
		/// Returns the Buying price of a product
		return buyPrice;
	}
	
	public int getSellPrice() {
		/// Returns the Selling price of the product
		return sellPrice;
	}
	
	public void updateProfit(int value) {
		/// add the profit what we get from selling to the profit variable
		profit += value;
	}
	
	public int piecesAvailable() {
		/// returns the number of pieces available in the inventory
		return availablePieces;
	}
	
	public void addProduct(int count) {
		/// adds count if existing product is added
		availablePieces += count;
	}
	
	public void sellProduct(int count) {
		/// reduces count if product is sold
		availablePieces -= count;
	}
	
	public int getProductName() {
		/// returns the name of the product
		return name;
	}
	
	
	public HashMap < String, String > productInfo() {
		/// A getter method used to return the whole product information
	
		HashMap<String, String> product = new HashMap<String, String>();
		product.put("Name", name + "");
		product.put("Buy", buyPrice + "");
		product.put("Sell", sellPrice + "");
		product.put("Count", availablePieces + "");
		product.put("Profit", profit + "");
		return product;
	}
}
