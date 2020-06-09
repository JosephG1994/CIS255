package test;

public class Square extends Rectangle{
		
	// constructor
	public Square(int[] sideLengths){
		super(sideLengths);
	}
	
	// toString method
    @Override
    public String toString(){
    	String s = super.toString();
    	s += "\nI am a square.";
    	return s;
    }
}
