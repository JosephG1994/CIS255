package test;

public abstract class Amphibian extends Animal implements WaterLiveable {
	
	// constructor
	public Amphibian(String name) {
		super(name);
	}
	
	// isWarmBlooded
	@Override
	public boolean isWarmBlooded() {
		return false;
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
}
    	 
  
   