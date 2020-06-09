package test;
import java.util.Scanner;

public class PolyShapeDriver {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		// create menu with options
		boolean quit = false;
		do {                                                                       
			System.out.println("Enter \"p\" to create a polygon\nEnter \"q\" to create a quadrilateral\nEnter \"r\" to create a rectangle"
					+ "\nEnter \"s\" to create a square\nEnter \"t\" to create a triangle\nEnter any other character to quit");
			String s = scan.nextLine();
			if(s.equals("p")) {
				makePolyShape();
			} else if (s.equals("q")) {
				makeQuadrilateral();
			} else if (s.equals("r")) {
				makeRectangle();
			} else if (s.equals("s")) {
				makeSquare();
			} else if (s.equals("t")) {
				makeTriangle();
			} else {
				quit = true;
			}
		} while (!quit);
	}
	
	// polygon option
    public static void makePolyShape() {
    	System.out.println("How many sides?");
    	int numSides = Integer.parseInt(scan.nextLine());
    	int[] sideLengths = new int[numSides];
    	for(int i = 0; i < numSides; i++) {
    		System.out.println("Enter the length of side #" + (i+1) + ":");
    		sideLengths[i] = Integer.parseInt(scan.nextLine());
    	}
    	PolyShape p = new PolyShape(numSides,sideLengths);
    	System.out.println(p);
    	System.out.println("Perimeter: " + p.getPerimeter());
    }
    
    // quadrilateral option
    public static void makeQuadrilateral() {
    	int[] sideLengths = new int[4];
    	for(int i = 0; i < 4; i++) {
    		System.out.println("Enter the length of side #" + (i+1) + ":");
	    	sideLengths[i] = Integer.parseInt(scan.nextLine());
    	}
	    Quadrilateral q = new Quadrilateral(sideLengths);
	    System.out.println(q);
    	System.out.println("Perimeter: " + q.getPerimeter());
    }
    
    // rectangle option
    public static void makeRectangle() {
    	int[] sideLengths = new int[4];
	    System.out.println("Enter the length: ");
	    sideLengths[0] = Integer.parseInt(scan.nextLine());
	    sideLengths[1] = sideLengths[0];
	    System.out.println("Enter the width: ");
	    sideLengths[2] = Integer.parseInt(scan.nextLine());
	    sideLengths[3] = sideLengths[2];
	    Rectangle r = new Rectangle(sideLengths);
	    System.out.println(r);
	    System.out.println("Perimeter: " + r.getPerimeter());
	    System.out.println("Area: " + r.getArea());
    }
    
    // square option
    public static void makeSquare() {
    	int[] sideLengths = new int[4];
	    System.out.println("Enter the side length: ");
	    sideLengths[0] = Integer.parseInt(scan.nextLine());
    	sideLengths[1] = sideLengths[0];
    	sideLengths[2] = sideLengths[0];
    	sideLengths[3] = sideLengths[0];
    	Square s = new Square(sideLengths);
    	System.out.println(s);
    	System.out.println("Perimeter: " + s.getPerimeter());
    	System.out.println("Area: " + s.getArea());
    }
    
    // triangle option
    public static void makeTriangle() {
	    int[] sideLengths = new int[3];
	    for(int i = 0; i < 3; i++) {
	    	System.out.println("Enter the length of side #" + (i+1) + ":");
	    	sideLengths[i] = Integer.parseInt(scan.nextLine());
    	}
	    Triangle t = new Triangle(sideLengths);
    	System.out.println(t);
    	System.out.println("Perimeter: " + t.getPerimeter());
	    if(t.isEquilateral() == true) {
	    	System.out.println("I am equilateral.");
    	} else {
    		System.out.println("I am not equilateral.");
    	}
    	if(t.isIsoceles() == true) {
    		System.out.println("I am isoceles.");
    	} else {
    		System.out.println("I am not isoceles.");
    	}
    }
}

