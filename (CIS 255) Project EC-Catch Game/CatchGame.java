package test;

import javax.swing.JFrame;
import java.awt.Dimension;

public class CatchGame {

	public static void main(String[] args){

		// create JFrame
		JFrame frame = new JFrame("Catch It! Game");
    	frame.setPreferredSize(new Dimension(500,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create CatchGamePanel and CatchControlPanel
		CatchGamePanel gamePanel = new CatchGamePanel();
		CatchControlPanel controlPanel = new CatchControlPanel(gamePanel);

		// set positions of the two panels
		frame.getContentPane().add(gamePanel, "Center");
		frame.getContentPane().add(controlPanel, "South");
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
