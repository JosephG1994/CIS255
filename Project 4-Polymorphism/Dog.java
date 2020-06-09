package test;

public class Dog extends Mammal implements Adoptable {
	
	// constructor
	public Dog(String name) {
		super(name);
	}

	// toString method
	@Override
	public String toString() {
		return super.toString();
	}
	
	// implement Adoptable interface
	@Override
	public String getHomeCareInstructions(){
		return getName() + " is adoptable.";
	}
}
