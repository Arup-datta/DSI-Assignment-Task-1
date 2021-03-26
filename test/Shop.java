package test;

import java.util.*;

public class Shop {
	
	public void start() {
		// start function contains the conditions to run the program
		Scanner sc = new Scanner(System.in);
		ProductList list = new ProductList();
		
		while(true) {
			System.out.println("Enter operation number:\n");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				/// Add product
				
				System.out.println("Enter product name: ");
				int name = sc.nextInt();
				System.out.println("Enter buy price: ");
				int buy = sc.nextInt();
				System.out.println("Enter sell price: ");
				int sell = sc.nextInt();
				System.out.println("Available number in the inventory to sell: ");
				int count = sc.nextInt();
				
				
				list.addProduct(name, buy, sell, count);
				
				System.out.println("Product is added!");
				
			}
			else if(choice == 2) {
				// Delete a Product
				
				System.out.println("Enter the name of the product that you want to delete: ");
				int name = sc.nextInt();
				list.deleteProduct(name);
			}
			else if(choice == 3) {
				// Buy product
				
				System.out.println("Enter the product name you want to buy: ");
				int name = sc.nextInt();
				System.out.println("Enter the amount of product you want to buy: ");
				int amount = sc.nextInt();
				
				list.buyProduct(name, amount);
				
			}
			else if(choice == 4) {
				/// Sell product
				
				System.out.println("Enter the product name you want to sell: ");
				int name = sc.nextInt();
				System.out.println("Enter the amount of product you want to sell: ");
				int amount = sc.nextInt();
				
				list.sellProduct(name, amount);
			}
			else if(choice == 5) {
				/// Show product list
				
				System.out.println("Available product list:\n");
				list.showProductList();
			}
			else if(choice == 6) {
				/// check available balance
				
				System.out.println("Total balance: " + Balance.getBalance());
			}
			else {
				// terminate the program
				System.exit(0);
			}
		}
	}

}
