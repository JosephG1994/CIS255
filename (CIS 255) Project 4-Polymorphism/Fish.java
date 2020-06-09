package test;

public abstract class Fish extends Animal implements WaterLiveable {
	
	// constructor
    public Fish(String name) {
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
    	return false;	
    }
}
