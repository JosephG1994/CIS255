package test;

public class Triangle extends PolyShape {

	// instance data variable
	private static final int TRIANGLE_SIDES = 3;

	// constructor
	public Triangle(int[] sideLengths){
		super(TRIANGLE_SIDES, sideLengths);
	}
	
	// toString method
    @Override
    public String toString(){
    	String s = super.toString();
    	s += "\nI am a triangle.";
    	return s;
    }

    // isIsoceles method
	public boolean isIsoceles() {
		if(this.getSideLengths()[0] == this.getSideLengths()[1] || this.getSideLengths()[0] == this.getSideLengths()[2] || this.getSideLengths()[1] == this.getSideLengths()[2]){
			return true;
		} else {
			return false;
		}
	}
    // isEquilateral method
	public boolean isEquilateral() {
		if(this.getSideLengths()[0] == this.getSideLengths()[1] && this.getSideLengths()[1] == this.getSideLengths()[2]){
			return true;
		} else { 
			return false;
		}
	}
}

