package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CatchControlPanel extends JPanel{

	// references
	CatchGamePanel panel;	
	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;

	// constants
	public static final int EASY_DELAY = 2000;
	public static final int MEDIUM_DELAY = 1000;
	public static final int HARD_DELAY = 500;
	
	// method for CatchControlPanel
	public CatchControlPanel(CatchGamePanel panel){
		this.panel = panel;

		// create event handler
		ButtonListener listener = new ButtonListener();

		// create easy, medium, and hard buttons
		easy = new JRadioButton("Easy", true);
		medium = new JRadioButton("Medium");
		hard = new JRadioButton("Hard");
		
		// register events for JRadioButtons
		easy.addActionListener(listener);
		medium.addActionListener(listener);
		hard.addActionListener(listener);

		// group together the three JRadioButtons
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);

		// add the buttons to the panel
		add(easy);
		add(medium);
		add(hard);
	}

	// handler class
	private class ButtonListener implements ActionListener { 

		// ActionListener event handlers
		public void actionPerformed(ActionEvent event) { 
			Object source = event.getSource();

			// when the easy button is pressed
			if (source == easy) {
				panel.setDelay(EASY_DELAY);

			// when the medium button is pressed
			} else if (source == medium) {
				panel.setDelay(MEDIUM_DELAY);

			// when the hard button is pressed
			} else if (source == hard) {
				panel.setDelay(HARD_DELAY);
			}
		}
	}
}
