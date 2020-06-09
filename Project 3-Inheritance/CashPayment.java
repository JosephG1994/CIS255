package test;

public class CashPayment extends Payment {

	// instance data variables
    
	// constructor
	public CashPayment(double amountOfMoney, String date){
		super(amountOfMoney, date);
	
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
		return super.toString();
	}
}
