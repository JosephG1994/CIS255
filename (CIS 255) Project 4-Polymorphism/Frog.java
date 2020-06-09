package test;

public class Frog extends Amphibian implements WaterLiveable, Adoptable {

	// constructor
	public Frog(String name) {
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
    	return true; 
    }
    
    // implement Adoptable interface
    @Override
    public String getHomeCareInstructions() {
    	return getName() + " is adoptable.";
    }
}
