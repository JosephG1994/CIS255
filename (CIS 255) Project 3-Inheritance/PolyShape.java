package test;

public class PolyShape {
	
	// instance data variables
	private int numSides;
	private int[] sideLengths;
	
	/*
	 * note: PolyShape takes in an int[] because we don't know
	 * in advance how many sides a polygon will have... but that
	 * doesn't mean the child classes have to follow that same
	 * setup- make sure the parameters of the child class 
	 * constructors make sense for that class!
	 * 
	 * also note: there is no error checking here to make sure
	 * that sideLengths has the appropriate number of values; for now,
	 * we just assume the user will send in the proper information
	 */
	
	// constructor
	public PolyShape(int numSides, int[] sideLengths) {
		this.numSides = numSides;
		this.sideLengths = sideLengths;
	}
	
	// getter and setter methods
	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}
	public int getNumSides() {
		return numSides;
	}
	public void setSideLengths(int[] sideLengths) {
		this.sideLengths = sideLengths;
	}
	public int[] getSideLengths() {
		return sideLengths;
	}
	public int getPerimeter() {
		int perim = 0;
		for(int n : sideLengths)
			perim += n;
		return perim;
	}
	
	// toString method
	public String toString() {
		String s = "I am a shape with " + numSides + " sides of length: ";
		for(int length : sideLengths) 
			s += length + " ";
		s += "\nI am a polygon.";
		return s;
	}
}
