package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DrawingOptionsPanel extends JPanel {

	// references
	DrawingPanel drawingPanel;
	JRadioButton redButton;
	JRadioButton yellowButton;
	JRadioButton blueButton;
	JRadioButton eraserButton;
	JButton clearButton;

    // method for options panel
	public DrawingOptionsPanel(DrawingPanel d) {
		this.drawingPanel = d;
		// create event handler
		DrawingOptionsListener listener = new DrawingOptionsListener();
		
		// clear drawing button
		this.clearButton = new JButton("Clear Drawing");
		this.clearButton.addActionListener(listener);

		// red button
		this.redButton = new JRadioButton("Red");
		this.redButton.setBackground(Color.black);
		this.redButton.setForeground(Color.white);

		// yellow button
		this.yellowButton = new JRadioButton("Yellow");
		this.yellowButton.setBackground(Color.black);
		this.yellowButton.setForeground(Color.white);

		// blue button
		this.blueButton = new JRadioButton("Blue");
		this.blueButton.setBackground(Color.black);
		this.blueButton.setForeground(Color.white);

		// eraser button
		this.eraserButton = new JRadioButton("Eraser");
		this.eraserButton.setBackground(Color.black);
		this.eraserButton.setForeground(Color.white);

		// group together the four JRadiobuttons
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(this.redButton);
		radioGroup.add(this.yellowButton);
		radioGroup.add(this.blueButton);
		radioGroup.add(this.eraserButton);
        
		// register events for JRadioButtons
		this.redButton.addActionListener(listener);
		this.yellowButton.addActionListener(listener);
		this.blueButton.addActionListener(listener);
		this.eraserButton.addActionListener(listener);
		
		// set color of options panel
		this.setBackground(Color.black);
		
		// add the buttons to the panel
		this.add(this.redButton);
		this.add(this.yellowButton);
		this.add(this.blueButton);
		this.add(this.eraserButton);
		this.add(this.clearButton);
	}

	// handler class
	private class DrawingOptionsListener implements ActionListener {
		// ActionListener event handlers
		@Override
		public void actionPerformed(ActionEvent event) {
			Object src = event.getSource();
			
			// when the clear button is pressed 
			if (src == DrawingOptionsPanel.this.clearButton) {
				DrawingOptionsPanel.this.drawingPanel.clear();

			// when the red button is pressed
			} else if (src == DrawingOptionsPanel.this.redButton) {	
				DrawingOptionsPanel.this.drawingPanel.penColor = Color.red;
				DrawingOptionsPanel.this.drawingPanel.drawEraser = false;

			// when the yellow button is pressed
			} else if (src == DrawingOptionsPanel.this.yellowButton) {
				DrawingOptionsPanel.this.drawingPanel.penColor = Color.yellow;
				DrawingOptionsPanel.this.drawingPanel.drawEraser = false;
				
			// when the blue button is pressed	
			} else if (src == DrawingOptionsPanel.this.blueButton) {
				DrawingOptionsPanel.this.drawingPanel.penColor = Color.blue;
   	    		DrawingOptionsPanel.this.drawingPanel.drawEraser = false;
				
			// when the eraser button is pressed
			} else if (src == DrawingOptionsPanel.this.eraserButton) {
				DrawingOptionsPanel.this.drawingPanel.penColor = Color.white;
				DrawingOptionsPanel.this.drawingPanel.drawEraser = true;
			}
		}
	}
}