package test;

public class Quadrilateral extends PolyShape {
	
	// instance data variable
	private static final int QUADRILATERAL_SIDES = 4;
	
	// constructor
	public Quadrilateral(int[] sideLengths){
		super(QUADRILATERAL_SIDES, sideLengths);
	}
	
	// toString method
    @Override
    public String toString(){
    	String s = super.toString();
    	s += "\nI am a quadrilateral.";
    	return s;
    }
}
