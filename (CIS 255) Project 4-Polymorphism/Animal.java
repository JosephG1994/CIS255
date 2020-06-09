package test;

public abstract class Animal implements Comparable<Animal> {

	// instance data variables
	private String name;
	private boolean warmBlooded;
	
	// constructor
	public Animal(String name) {
		this.name = name;
	}

	// getter methods
	public String getName() {
		return name;
	}
	public boolean isWarmBlooded() {
		return warmBlooded;
	}
	
	// setter methods
	public void setName(String name) {
		this.name = name;
	}
	public void setWarmBlooded(boolean warmBlooded) {
		this.warmBlooded = warmBlooded;
	}
	
	// toString method
	@Override
	public String toString(){
		return "Name: " + name;
	}
	
	// commpareTo method
    @Override    
	public int compareTo(Animal otherAnimal){
		if(name.equalsIgnoreCase(otherAnimal.name)) {
			return name.compareToIgnoreCase(otherAnimal.name);
		} else {
			return name.compareToIgnoreCase(otherAnimal.name);
		}
	}	
}
