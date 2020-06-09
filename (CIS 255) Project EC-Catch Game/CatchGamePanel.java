package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class CatchGamePanel extends JPanel{

	// instance data variables
	private int width, height;
	private int count = 0;

	private int delay = 2000;
	private int x, y; 
	private int length = 20;

	private Timer timer;	
	Random random;

	// constructor
	public CatchGamePanel() {
		timer = new Timer(delay, new TimerListener());
		random = new Random();
		width = 500;
		height = 500;
		x = random.nextInt(width - length);
		y = random.nextInt(height - length);
		timer.start();
		addMouseListener(new ClickListener());
	}

	// draw rectangles on window
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.black);
		g.setColor(Color.green);
		g.fillRect(x, y, length, length);
		g.setColor(Color.pink);
		g.setFont(new Font("Calibri", 0, 24));
		g.drawString("Hit Count: " + count, 200, 25);
	}

	// method for clicking target
	public boolean clickIsInSquare(Point point) {
		double pointX = point.getX();
		double pointY = point.getY();
		if ((pointX >= x) && (pointX <= x + length) && (pointY >= y) && (pointY <= y + length)) {
			return true;
		}
		return false;
	}

	// method for getting count
	public int getCount()
	{
		return this.count;
	}

	// method for setting timer delay
	public void setDelay(int delay) {
		this.delay = delay;
		this.timer.setDelay(delay);
	}

	// handler class
	private class TimerListener implements ActionListener {

		// ActionListener event handlers
		public void actionPerformed(ActionEvent event) { 
			x = random.nextInt(width - length);
			y = random.nextInt(height - length);
			repaint();
		}
	}

	// handler class
	private class ClickListener extends MouseAdapter { 

		// MouseAdapter event handlers
		public void mouseClicked(MouseEvent e) { 
			Point point = e.getPoint();

			// when the target is clicked
			if (clickIsInSquare(point)) {
				count += 1;
				repaint();
			}
		}
	}
}
