/*
 * Program Purpose: Final Project for AP CS, a Yahtzee game
 * Names: Kai Wang and Sathvik Inteti, Team 7
 * Date: 6/8/19
 * Period: 5
 * Revision #: 1
 */

import java.util.Scanner;

public class Person extends setOfDice {

	//fields
	private String name;
	private int score;
	private int counter;

	boolean isTurn = false;

	// constructor
	public Person(String name1) {
		name = name1;
		score = 0;
		counter = 0;
	}

	// Returns the value of counter
	public int getCounter() {
		return counter;
	}

	// returns name
	public String getName() {
		return name;
	}

	// returns score
	public int getScore() {
		return score;
	}

	// updates score depending on hand selected
	public void setScore(int points) {
		score += points;
	}

	// Increments the counter
	public void increment() {
		counter++;
	}

	// Changes the turn
	public void changeTurn() {
		isTurn = !isTurn;
	}

	// Returns the value of turn
	public boolean getTurn() {
		return isTurn;
	}
}
