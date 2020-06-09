package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGUI extends JFrame {

	// constants
	public static int ROCK = 1;
	public static int PAPER = 2;
	public static int SCISSORS = 3;
	public static int CWIN = 1;
	public static int UWIN = 2;
	public static int TIE = 3;

	// buttons for the user to enter their move
	private JButton rockButton, paperButton, scissorsButton;

	// labels to display the number of wins/losses/ties
	private JLabel statusC, statusU, statusT, balance;

	// images and labels to display the computer and user's moves and the outcome of a match-up
	private ImageIcon rockImage, paperImage, scissorsImage;
	private JLabel compPlay, userPlay;
	private JLabel outcome;

	// the game object
	private RPSGame game;

	// constructor
	public RPSGUI(int betAmount) {

		// initializes the window
		super("Rock, Paper, Scissors, Go!");
		setSize(350, 300);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.black);
		setResizable(false);

		// creates the game object
		game = new RPSGame(betAmount);
		// 	NOTE: IF COMPLETING THE EXTRA CREDIT, YOU WILL CHANGE THE 0 PARAMETER TO A VARIABLE THAT REPRESENTS THE BET AMOUNT

		// creates the labels for displaying the computer and user's move;
		// the images for the moves and the outcome of a match-up will be displayed
		// in a single panel
		rockImage = new ImageIcon("rock.jpg");
		paperImage = new ImageIcon("paper.jpg");
		scissorsImage = new ImageIcon("scissors.jpg");

		compPlay = new JLabel();
		compPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		compPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		compPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		compPlay.setForeground(Color.cyan);

		userPlay = new JLabel();
		userPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		userPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		userPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		userPlay.setForeground(Color.cyan);

		outcome = new JLabel();
		outcome.setHorizontalTextPosition(SwingConstants.CENTER);
		outcome.setForeground(Color.pink);

		JPanel imageOutcomePanel = new JPanel();
		imageOutcomePanel.setBackground(Color.black);
		imageOutcomePanel.setLayout(new BorderLayout());
		imageOutcomePanel.add(compPlay, BorderLayout.WEST);
		imageOutcomePanel.add(userPlay, BorderLayout.EAST);
		imageOutcomePanel.add(outcome, BorderLayout.SOUTH);

		// creates the labels for the status of the game (number of wins, losses, and ties);
		// the status labels will be displayed in a single panel
		statusC = new JLabel("Computer Wins: " + game.getCWins());
		statusU = new JLabel("User Wins: " + game.getUWins());
		statusT = new JLabel("Ties: " + game.getTies());
		statusC.setForeground(Color.white);
		statusU.setForeground(Color.white);
		statusT.setForeground(Color.white);

		balance = new JLabel("Your Balance: $" + game.getUserMoney());
		balance.setForeground(Color.white);

		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.black);
		statusPanel.add(statusC);
		statusPanel.add(statusU);
		statusPanel.add(statusT);

		if(game.isBetting()){
			statusPanel.add(balance);
		}
		// the play and status panels are nested in a single panel
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(250, 250));
		gamePanel.setBackground(Color.black);
		gamePanel.add(imageOutcomePanel);
		gamePanel.add(statusPanel);

		// creates the buttons and displays them in a control panel;
		// one listener is used for all three buttons
		rockButton = new JButton("Play Rock");
		rockButton.addActionListener(new GameListener());
		paperButton = new JButton("Play Paper");
		paperButton.addActionListener(new GameListener());
		scissorsButton = new JButton("Play Scissors");
		scissorsButton.addActionListener(new GameListener());

		JPanel controlPanel = new JPanel();
		controlPanel.add(rockButton);
		controlPanel.add(paperButton);
		controlPanel.add(scissorsButton);
		controlPanel.setBackground(Color.black);

		// the gaming and control panel are added to the window
		contentPane.add(gamePanel, BorderLayout.CENTER);
		contentPane.add(controlPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	// method for computer moves
	private void updateComputerDisplay(int cPlay) {
		if (cPlay == ROCK) {
			compPlay.setIcon(rockImage);
		} else if (cPlay == PAPER) {
			compPlay.setIcon(paperImage);
		} else if (cPlay == SCISSORS) {
			compPlay.setIcon(scissorsImage);
		}
		compPlay.setText("Computer's Move");
	}

	// method for user moves
	private void updateUserDisplay(int uPlay) {
		if (uPlay == ROCK) {
			userPlay.setIcon(rockImage);
		} else if (uPlay == PAPER) {
			userPlay.setIcon(paperImage);
		} else if (uPlay == SCISSORS) {
			userPlay.setIcon(scissorsImage);
		}
		userPlay.setText("Your Move");
	}

	// method for updating game status
	private void updateStatusDisplay(int gameStatus, int userMove, int compMove) {
		if (gameStatus == TIE) {
			outcome.setText("It's a tie!");

		} else if (gameStatus == CWIN) {
			String outputText = "";
			outputText = compMove == ROCK ? "Rock smashes Scissors!" : (compMove == PAPER ? "Paper smothers Rock!" : "Scissors shred Paper!");
			outcome.setText(String.valueOf(outputText) + " You lose!");

		} else if (gameStatus == UWIN) {
			String outputText = "";
			outputText = userMove == ROCK ? "Rock smashes Scissors!" : (userMove == PAPER ? "Paper smothers Rock!" : "Scissors shred Paper!");
			outcome.setText(String.valueOf(outputText) + " You win!");
		}
		statusT.setText("Ties: " + game.getTies());
		statusU.setText("User Wins: " + game.getUWins());
		statusC.setText("Computer Wins: " + game.getCWins());
		balance.setText("Your Balance: $" + game.getUserMoney());
	}
	/* determines which button was clicked and updates the game accordingly */
	private class GameListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Object source = event.getSource();
			int userPlay = -1;

			// when the rock button is pressed
			if (source == RPSGUI.this.rockButton) {
				userPlay = ROCK;

				// when the paper button is pressed
			} else if (source == RPSGUI.this.paperButton) {
				userPlay = PAPER;

				// when the scissors button is pressed
			} else if (source == RPSGUI.this.scissorsButton) {
				userPlay = SCISSORS;
			}

			// update outcome display and game stats
			RPSGUI.this.updateUserDisplay(userPlay);
			int computerPlay = RPSGUI.this.game.generateComputerPlay();
			RPSGUI.this.updateComputerDisplay(computerPlay);
			int winner = RPSGUI.this.game.findWinner(userPlay, computerPlay);
			RPSGUI.this.updateStatusDisplay(winner, userPlay, computerPlay);
		}
	}

	public static void main(String args[]) {
		int betAmount = 0;
		if (JOptionPane.showConfirmDialog(null, "Do you want to place a bet?") == 0) {
			betAmount = Integer.parseInt(JOptionPane.showInputDialog("How much per round?"));
		}
		// create an object of your class
		RPSGUI frame = new RPSGUI(betAmount);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

