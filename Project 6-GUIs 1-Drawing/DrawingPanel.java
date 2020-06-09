package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	// instance data variables
	private boolean drawing;
	protected boolean drawEraser; // eraser icon
	protected Color penColor = Color.white;
	private ArrayList<ColorPoint> points; // array list for keeping track of drawn points
	private final int POINT_SIZE = 10; // size of pen 
	private Point erasePoint; // erased points

	// constructor
	public DrawingPanel() {
		this.setBackground(Color.white);
		this.setSize(500, 500);
	
		this.drawing = false;
		this.drawEraser = false;
		this.points = new ArrayList<>(); 
		this.erasePoint = new Point();
		
		// register event handlers
		DrawingListener listener = new DrawingListener();
		this.addMouseListener(listener);	
		this.addMouseMotionListener(listener);
					
	}

	// draw ovals at specified locations on window
    @Override
	public void paintComponent(Graphics pen) {
	    super.paintComponent(pen); // clears drawing area
	    	
	    // draw all points
	    for (ColorPoint point : this.points) {
	        pen.setColor(point.c);
	    	pen.fillOval(ColorPoint.access$200(point).x - 5, ColorPoint.access$200(point).y - 5, POINT_SIZE, POINT_SIZE);
	    }
  
		if (this.drawEraser) {
			pen.setColor(Color.black); // color of eraser
			pen.drawOval(this.erasePoint.x - 5, this.erasePoint.y - 5, POINT_SIZE, POINT_SIZE); // size of eraser
		}
	}
    
	// method for clearing drawing space
	public void clear() {
		this.points = new ArrayList<>(); // array list for keeping track of erased points
		this.repaint(); // repaint JPanel
	}

	// method for coloring drawn points
	private static class ColorPoint {
		private Point p;
    	private Color c;

		public ColorPoint(Point p, Color c) {
			this.p = p;
			this.c = c;
		}

		static Point access$200(ColorPoint x) {
			return x.p;
		}
	}
 
	// handler class
	private class DrawingListener implements MouseListener, MouseMotionListener {

        // MouseListener event handlers
		// handle event when mouse released immediately after press
		@Override
		public void mouseClicked(MouseEvent event) {
			DrawingPanel.this.drawing = !DrawingPanel.this.drawing;
		}

		// handle event when mouse enters area
		@Override
		public void mouseEntered(MouseEvent event) {
		}

		// handle event when mouse exits area
		@Override
		public void mouseExited(MouseEvent event) {
		}	

		// handle event when mouse pressed
		@Override
		public void mousePressed(MouseEvent event) {
		}		

		// handle event when mouse released
     	@Override
		public void mouseReleased(MouseEvent event) {
		}

		// MouseMotionListener event handlers
		// handle event when user drags mouse with button pressed
		@Override
		public void mouseDragged(MouseEvent event) {
		}

		// handle event when user moves mouse
		@Override
		public void mouseMoved(MouseEvent event) {
			if (DrawingPanel.this.drawing) {
				Point point = event.getPoint();
				DrawingPanel.this.points.add(new ColorPoint(point, DrawingPanel.this.penColor));
				DrawingPanel.this.repaint(); // repaint JPanel
			}
			if (DrawingPanel.this.drawEraser) {
				DrawingPanel.this.erasePoint = event.getPoint();
			}			
		}
	}
}

