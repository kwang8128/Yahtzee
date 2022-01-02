/*
 * Program Purpose: Final Project for AP CS, a Yahtzee game
 * Names: Kai Wang and Sathvik Inteti, Team 7
 * Date: 6/8/19
 * Period: 5
 * Revision #: 1
 */

public class setOfDice {
	// fields
	private Dice dice1;
	private Dice dice2;
	private Dice dice3;
	private Dice dice4;
	private Dice dice5;

	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;

	private int[] set;

	// constructor
	public setOfDice() {
		dice1 = new Dice();
		dice2 = new Dice();
		dice3 = new Dice();
		dice4 = new Dice();
		dice5 = new Dice();

		set = new int[] { dice1.getValue(), dice2.getValue(), dice3.getValue(), dice4.getValue(), dice5.getValue() };
	}

	// rolls the dice
	public void roll(boolean[] arr) {
		for (int i = 0; i < set.length; i++)
			if (arr[i] == true) {
				switch (i + 1) {
				case 1:
					dice1.roll();
					set[i] = dice1.getValue();
					break;
				case 2:
					dice2.roll();
					set[i] = dice2.getValue();
					break;
				case 3:
					dice3.roll();
					set[i] = dice3.getValue();
					break;
				case 4:
					dice4.roll();
					set[i] = dice4.getValue();
					break;
				case 5:
					dice5.roll();
					set[i] = dice5.getValue();
					break;
				}

			}
	}

	// get dice number
	public int getDiceNum(int diceNum) {
		return set[diceNum];
	}

	// count how many times each number appears
	public void enumerateValues() {
		num1 = 0;
		num2 = 0;
		num3 = 0;
		num4 = 0;
		num5 = 0;
		num6 = 0;
		for (int num : set) {
			switch (num) {
			case 1:
				num1++;
				break;
			case 2:
				num2++;
				break;
			case 3:
				num3++;
				break;
			case 4:
				num4++;
				break;
			case 5:
				num5++;
				break;
			case 6:
				num6++;
				break;
			}
		}
	}

	// calculates upper section of board
	public int calcUpperSection(int value) {
		enumerateValues();
		switch (value) {
		case 1:
			return num1;
		case 2:
			return value * num2;
		case 3:
			return value * num3;
		case 4:
			return value * num4;
		case 5:
			return value * num5;
		case 6:
			return value * num6;
		default:
			return 0;
		}
	}

	// checks and calculates three of a kind
	public int calcThreeOfAKind() {
		enumerateValues();
		if (num1 >= 3 || num2 >= 3 || num3 >= 3 || num4 >= 3 || num5 >= 3 || num6 >= 3) {
			return calcSumOfAllDice();
		} else {
			return 0;
		}
	}

	// checks and calculates four of a kind
	public int calcFourOfAKind() {
		enumerateValues();
		if (num1 >= 4 || num2 >= 4 || num3 >= 4 || num4 >= 4 || num5 >= 4 || num6 >= 4) {
			return calcSumOfAllDice();
		} else {
			return 0;
		}
	}

	// checks and calculates full house
	public int calcFullHouse() {
		enumerateValues();
		if ((num1 == 3 || num2 == 3 || num3 == 3 || num4 == 3 || num5 == 3 || num6 == 3)
				&& (num1 == 2 || num2 == 2 || num3 == 2 || num4 == 2 || num5 == 2 || num6 == 2)) {
			return 25;
		} else {
			return 0;
		}
	}

	// checks and calculates small straight
	public int calcSmallStraight() {
		enumerateValues();
		if ((num1 >= 1 && num2 >= 1 && num3 >= 1 && num4 >= 1) || (num2 >= 1 && num3 >= 1 && num4 >= 1 && num5 >= 1)
				|| (num3 >= 1 && num4 >= 1 && num5 >= 1 && num6 >= 1)) {
			return 30;
		} else {
			return 0;
		}
	}

	// checks and calculates large straight
	public int calcLargeStraight() {
		enumerateValues();
		if ((num1 >= 1 && num2 >= 1 && num3 >= 1 && num4 >= 1 && num5 >= 1)
				|| (num2 >= 1 && num3 >= 1 && num4 >= 1 && num5 >= 1 && num6 >= 1)) {
			return 40;
		} else {
			return 0;
		}
	}

	// checks and calculates Yahtzee
	public int calcYahtzee() {
		enumerateValues();
		if (num1 == 5 || num2 == 5 || num3 == 5 || num4 == 5 || num5 == 5 || num6 == 5) {
			return 50;
		} else {
			return 0;
		}
	}

	// calculates chance
	public int calcChance() {
		return calcSumOfAllDice();
	}

	// calculates sum of all dice
	public int calcSumOfAllDice() {
		int sum = 0;
		for (int num : set)
			sum += num;
		return sum;
	}

}
