package test;

public class Balance {
	static int balance = 0;
	/// kept it static for global access
	
	public static int getBalance() {
		/// returns the total balance
		return balance;
	}
	
	public static void addBalance(int value) {
		// updates balances (adds)
		balance += value;
	}
	
	public static void reduceBalance(int value) {
		// updates balance (deletes)
		balance -= value;
	}
}
