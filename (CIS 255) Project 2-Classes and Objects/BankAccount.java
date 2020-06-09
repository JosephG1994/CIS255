package test;

public class BankAccount {
	
	// instance data variables
	private String ownerName;
	private String accountID;
	private double accountBalance;
	private double initialBalance = 150;
	private int zeroBalance = 0;
	
	// constructor for taking an initial balance
	public BankAccount(String ownerName, String accountID, double accountBalance) {
		accountBalance = initialBalance;
		this.ownerName = ownerName;
		this.accountID = accountID;
		this.accountBalance = accountBalance;
		}
	
	// constructor for opening account with no money
	public BankAccount (String ownerName, String accountID, int accountBalance) {
		accountBalance = zeroBalance;
		this.ownerName = ownerName;
		this.accountID = accountID;
		this.accountBalance = accountBalance;
	}
	// deposit method
	public void deposit(double amount) {
		double newAccountBalance = accountBalance + amount;
		if(newAccountBalance >= 0) {
			accountBalance = newAccountBalance;		
		}
		else { 
			System.out.println("Insufficient funds");
			accountBalance = newAccountBalance;
		}
	}
	// withdraw method
	public void withdraw(double amount) {
		double newAccountBalance = accountBalance - amount;
		if(newAccountBalance >= 0) {
			accountBalance = newAccountBalance;	
		}
		else { 
			System.out.println("Insufficient funds");
			accountBalance = newAccountBalance;
		}
	}
        // getter methods 
	public String getOwnerName() {
		return ownerName;
	}
	public String getAccountID() {
		return accountID;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	
	// setter methods
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public void setAccountBalance(double accountBalance) {
		if(accountBalance >= 0) {
			this.accountBalance = accountBalance;
		}
	}
	
	// toString Method
	public String toString() {
		String s ="Account Owner's Name:" + ownerName 
				+ "\nAccount ID: " + accountID 
				+ "\nBalance: " + accountBalance;
		return s;
	}
}

