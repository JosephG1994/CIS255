package test;

public class BankAccountDriver {

	public static void main(String[] args) {
		
		// create two bank accounts
		BankAccount bankaccount1 = new BankAccount("Bob", "1234" , 150.0);
		BankAccount bankaccount2 = new BankAccount("Joe", "5678" , 0); 
        
		// print account information
		System.out.println(bankaccount1.toString());
		System.out.println(bankaccount2.toString());
		
		// deposit and withdraw money from bank account 1
		bankaccount1.setAccountBalance(500.0);
		bankaccount1.deposit(2500.0);
		bankaccount1.withdraw(200.0);
		System.out.println(bankaccount1.getAccountBalance());
		bankaccount1.deposit(-4500.0); // invalid value
		System.out.println(bankaccount1.getAccountBalance());
		
		// deposit money from bank account 2
		bankaccount2.setAccountBalance(700.0);
		bankaccount2.withdraw(800.0); // invalid value
		System.out.println(bankaccount2.getAccountBalance());
	}
}
