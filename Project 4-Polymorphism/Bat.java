package test;

public class Bat extends Mammal implements Flyable {
	
	// instance data variable
	private int flightSpeed;
	
	// constructor
	public Bat(String name, int flightSpeed) {
		super(name);
		this.flightSpeed = flightSpeed;
	}
	
	// implement Flyable interface
	public int getFlightSpeed() {
		return flightSpeed;	
	}
	
	// setter method
	public void setFlightSpeed(int flightSpeed){
		if(flightSpeed > 0) {
			this.flightSpeed = flightSpeed;
		}
	}
	
	// toString method
	@Override
	public String toString() {
		return super.toString() + "\nFlight speed: " + flightSpeed;
	}
}

