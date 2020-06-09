package test;

public class Goldfish extends Fish implements WaterLiveable, Adoptable {

	// constructor
	public Goldfish(String name) {
		super(name);
	}

	// toString method
	@Override
	public String toString() {
		return super.toString();
	}

    // implement WaterLiveable interface
	@Override
    public boolean canLiveOnLand() {
		return false;
    }
    
    // implement Adoptable interface
    @Override
    public String getHomeCareInstructions() {
    	return getName() + " is adoptable.";
    }
}
