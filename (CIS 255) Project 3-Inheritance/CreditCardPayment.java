package test;

public class CreditCardPayment extends Payment {

	// instance data variables
	private String name, creditCardNumber;
	
	// constructor
	public CreditCardPayment(double amountOfMoney, String date, String name, String creditCardNumber) {
		super(amountOfMoney, date);
		this.name = name;
		this.creditCardNumber = creditCardNumber;
	}

	// getter methods
	public String getName(){
		return name;
	}
	
	public String getCreditCardNumber(){
		return creditCardNumber;
	}
	
	// setter methods
	public void setName(String name){
		this.name = name;		
	}
	
	public void setCreditCardNumber(String creditCardNumber){
		this.creditCardNumber = creditCardNumber;
	}
	
	// toString method
	@Override
	public String toString(){
		return super.toString()+ "\nName: " + name + "\nCredit Card Number: " + creditCardNumber;
	}
	
	// equals method
	@Override
	public boolean equals(Object obj){
		if(obj instanceof CreditCardPayment){
			CreditCardPayment otherCreditCardPayment = (CreditCardPayment) obj;
            boolean sameAmountOfMoney = this.amountOfMoney == otherCreditCardPayment.amountOfMoney;
            boolean sameDate = this.date.equalsIgnoreCase(otherCreditCardPayment.date);
            boolean sameName = this.name.equals(otherCreditCardPayment.name);
            boolean sameCreditCardNumber = this.creditCardNumber.equals(otherCreditCardPayment.creditCardNumber);
			return sameAmountOfMoney && sameDate && sameName && sameCreditCardNumber;
		} else {
			return false;
		}
	}
}


