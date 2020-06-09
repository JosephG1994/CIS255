package test;

import java.util.Random;

public class RPSGame {

	// constants
	public static int ROCK = 1;
	public static int PAPER = 2;
	public static int SCISSORS = 3;
	public static int CWIN = 1;
	public static int UWIN = 2;
	public static int TIE = 3;
	
	// instance data variables
	private int numCompWin = 0;
	private int numUserWin = 0;
	private int numTie = 0;
	private int betAmount, userMoney;
	private boolean betting;
	
	// constructor 
	public RPSGame(int betAmount) {
		this.betAmount = betAmount;
		this.betting = this.betAmount != 0;
		this.userMoney = 0;
	}

	// getter methods
	public int getUserMoney() {
		return this.userMoney;
	}

	public boolean isBetting() {
		return this.betting;
	}

	public int getCWins() {
		return this.numCompWin;
	}

	public int getUWins() {
		return this.numUserWin;
	}

	public int getTies() {
		return this.numTie;
	}

	// random method
	public int generateComputerPlay() {
		Random random = new Random();
		int play = random.nextInt(3) + 1;
		return play;
	}

	// method for results
	public int findWinner(int user, int comp) {

		// Computer and user play same item
		if (comp == user){
			++this.numTie;
			return TIE;
		}

		// Computer plays rock 
		if (comp == ROCK){
			if (user == PAPER){
				++this.numUserWin;
				this.userMoney += this.betAmount;
				return UWIN;
			} else if (user == SCISSORS){ 
				++this.numCompWin;
				this.userMoney -= this.betAmount;
				return CWIN;
			}
		}

		// Computer plays paper 
		if (comp == PAPER){
			if (user == ROCK){
				++this.numCompWin;
				this.userMoney -= this.betAmount;
				return CWIN;
			} else if (user == SCISSORS){ 
				++this.numUserWin;
				this.userMoney += this.betAmount;
				return UWIN;
			}
		}

		// Computer plays scissors
		if (comp == SCISSORS){
			if (user == ROCK){
				++this.numUserWin;
				this.userMoney += this.betAmount;
				return UWIN;
			} else if (user == PAPER){
				++this.numCompWin;
				this.userMoney -= this.betAmount;
				return CWIN;	
			}
		}
		return comp;
	}	
}
