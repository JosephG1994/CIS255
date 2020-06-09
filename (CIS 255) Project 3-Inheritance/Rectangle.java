package test;

public class Rectangle extends Quadrilateral {

	// constructor
	public Rectangle(int[] sideLengths){
		super(sideLengths);
	}
	
	// getArea method
	public int getArea(){
		int area = this.getSideLengths()[0] * this.getSideLengths()[2];
		return area;
	}
	
	// toString method
    @Override
    public String toString(){
    	String s = super.toString();
    	s += "\nI am a rectangle.";
    	return s;
    }
}
