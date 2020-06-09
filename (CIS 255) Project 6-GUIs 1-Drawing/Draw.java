package test;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Draw {
	
	public static void main(String[] args) {
		
		// create JFrame 
		JFrame frame = new JFrame("Draw Something!");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
		// create drawingPanel and optionsPanel
		DrawingPanel drawingPanel = new DrawingPanel();
		DrawingOptionsPanel optionsPanel = new DrawingOptionsPanel(drawingPanel);
		
		// set positions of drawing and options panel
		frame.getContentPane().add(drawingPanel, "Center");
		frame.getContentPane().add(optionsPanel, "South");
		frame.setVisible(true);
	}
}
