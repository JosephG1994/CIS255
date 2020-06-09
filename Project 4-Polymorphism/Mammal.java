package test;

public abstract class Mammal extends Animal {
	
    // constructor
	public Mammal(String name) {
		super(name);
	}
	
 	// isWarmBlooded
	@Override
	public boolean isWarmBlooded() {
		return true;
	}
	
	// toString method
	@Override
	public String toString() {
		return super.toString();
	}
}
