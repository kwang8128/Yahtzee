/*
 * Program Purpose: Final Project for AP CS, a Yahtzee game
 * Names: Kai Wang and Sathvik Inteti, Team 7
 * Date: 6/8/19
 * Period: 5
 * Revision #: 1
 */

public class Dice {
	// fields
	private int value;

	// constructor
	public Dice() {
		roll();
	}

	// rolls dice
	public void roll() {
		value = (int) (Math.random() * 6 + 1);
	}

	// gets value of dice
	public int getValue() {
		return value;
	}
}
