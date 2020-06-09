package test;

public class Whale extends Mammal implements WaterLiveable {

	// constructor
	public Whale(String name) {
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
}
