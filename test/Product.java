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
	
	
	public int getBuyPrice() {
		/// Returns the Buying price of a product
		return buyPrice;
	}
	
	public int getSellPrice() {
		/// Returns the Selling price of the product
		return sellPrice;
	}
	
	public int getPiecesAvailable() {
		/// returns the number of pieces available in the inventory
		return availablePieces;
	}
	
	public int getProductName() {
		/// returns the name of the product
		return name;
	}
	
	public int getProfit() {
		return profit;
	}
	
	
	/// Change functions
	
	public void updateProfit(int value) {
		/// add the profit what we get from selling to the profit variable
		profit += value;
	}
	

	public void addProduct(int count) {
		/// adds count if existing product is added
		availablePieces += count;
	}
	
	public void sellProduct(int count) {
		/// reduces count if product is sold
		availablePieces -= count;
	}
	

	
}
