package test;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Random;

public class SortGUI extends JPanel {

	private int[] selectionArray, insertionArray;

	// variables for the display
	private static final int ARRAY_SIZE = 50, BAR_WIDTH = 8, SPACE_APART = 5, MAX = 80, MIN = 1, SS_Y_START = 120, IS_Y_START = 270;
	private JButton changeButton;

	// variables for the sorting methods
	private boolean selectionSorted;
	private boolean insertionSorted;
	private int selectionIndex;
	private int insertionIndex;

	public SortGUI() {
		selectionArray = new int[ARRAY_SIZE];
		insertionArray = new int[ARRAY_SIZE];

		Random generator = new Random();
		int randomNumber;
		for(int i = 0; i < ARRAY_SIZE; i++){
			randomNumber = MIN + generator.nextInt(MAX - MIN + 1);
			selectionArray[i] = randomNumber;
			insertionArray[i] = randomNumber;
		}

		setBackground(Color.white);
		setPreferredSize(new Dimension(300, 300));

		selectionIndex = 0;
		insertionIndex = 1;

		changeButton = new JButton("Click to take one step in the search");
		add(changeButton);
		changeButton.addActionListener(new ButtonHandler());
	}

	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);

		int xPos = 20;

		pen.setColor(Color.blue);
		for (int index = 0; index < ARRAY_SIZE; index++) {
			pen.fillRect(xPos, SS_Y_START - selectionArray[index], BAR_WIDTH, selectionArray[index]);
			xPos = xPos + BAR_WIDTH + SPACE_APART; // adds width and spaces so bars don't overlap
		}

		xPos = 20; // resets x position

		pen.setColor(Color.black);
		pen.drawString("Selection Sort", xPos, SS_Y_START + 20);

		pen.setColor(Color.red);
		for (int index = 0; index < ARRAY_SIZE; index++) {
			pen.fillRect(xPos, IS_Y_START - insertionArray[index], BAR_WIDTH, insertionArray[index]);
			xPos = xPos + BAR_WIDTH + SPACE_APART; // adds width and spaces so bars don't overlap
		}

		xPos = 20; // resets x position

		pen.setColor(Color.black);
		pen.drawString("Insertion Sort", xPos, IS_Y_START + 20);

	}

	private void modifiedSelectionSort() {	
		if (selectionIndex < selectionArray.length - 1) {
			int minIndex = selectionIndex;
			int j = minIndex + 1;
			while (j < selectionArray.length) {
				if (selectionArray[j] < selectionArray[minIndex]) {
					minIndex = j;
				}
				++j;
			}
			swap(selectionArray, selectionIndex, minIndex);
		}
		++selectionIndex;
		if (selectionIndex == selectionArray.length - 1) {
			selectionSorted = true;
		}
	}
    
	private void modifiedInsertionSort() {
		if (insertionIndex < insertionArray.length) {
			int valueToInsert = insertionArray[insertionIndex];
			int locationToMoveTo = insertionIndex;
			while (locationToMoveTo > 0 && insertionArray[locationToMoveTo - 1] > valueToInsert) {
				insertionArray[locationToMoveTo] = insertionArray[locationToMoveTo - 1];
				--locationToMoveTo;
			}
			insertionArray[locationToMoveTo] = valueToInsert;
		}
		++insertionIndex;
		if (insertionIndex == insertionArray.length) {
			insertionSorted = true;
		}

	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public boolean isSelectionSorted() {
		return this.selectionSorted;
	}

	public boolean isInsertionSorted() {
		return this.insertionSorted;	
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			SortGUI.this.modifiedSelectionSort();
			SortGUI.this.modifiedInsertionSort();

			if ((isInsertionSorted()) && (isSelectionSorted())) {
				changeButton.setEnabled(false);
			}
			repaint();
		}
	}

	public static void main(String[] args) {
		SortGUI panel = new SortGUI();
		JFrame frame = new JFrame("Sort!");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(700, 350);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
