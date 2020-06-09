package test;

public class Payment {
	
	// instance data variables
	protected double amountOfMoney;
	protected String date;
		
	// constructor
	public Payment(double amountOfMoney, String date){
		this.amountOfMoney = amountOfMoney;
		this.date = date;
	}
	
	// getter methods
	public double getAmountOfMoney(){
		return amountOfMoney;
	}
	
	public String getDate(){
		return date;
	}
	
	// setter methods
	public void setAmountOfMoney(double amountOfMoney){
		if(amountOfMoney > 0){
			this.amountOfMoney = amountOfMoney;
		}
	}
	
	public void setDate(String date){
		this.date = date;
	}

	// toString method
	public String toString(){
		return "Date: " + date + "\nAmount: " + amountOfMoney;
	}
}
