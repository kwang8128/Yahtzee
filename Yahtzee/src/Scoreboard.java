/*
 * Program Purpose: Final Project for AP CS, a Yahtzee game
 * Names: Kai Wang and Sathvik Inteti, Team 7
 * Date: 6/8/19
 * Period: 5
 * Revision #: 1
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Scoreboard extends JPanel {
	// Initializes the object and variables that will be used to create the
	// scoreboard class
	private Person player;
	private Person player2;
	private JButton button;
	private int count;
	private int counter;
	private boolean val;
	private JButton[] buttons;
	private JLabel label;
	private JLabel turn;
	private JButton[] arr;

	JButton ones = new JButton("Ones");
	JButton twos = new JButton("Twos");
	JButton threes = new JButton("Threes");
	JButton fours = new JButton("Fours");
	JButton fives = new JButton("Fives");
	JButton sixes = new JButton("Sixes");
	JButton toak = new JButton("Three of a kind");
	JButton foak = new JButton("Four of a kind");
	JButton fh = new JButton("Full House");
	JButton ss = new JButton("Small Straight");
	JButton ls = new JButton("Large Straight");
	JButton yahtzee = new JButton("Yahtzee");
	JButton chance = new JButton("Chance");
	JLabel label2 = new JLabel("Bonus: ", SwingConstants.CENTER);

	// Constructor for the scoreboard class
	public Scoreboard(Person person, Person person2, JLabel label1, JButton roll, JButton button1, JButton button2,
			JButton button3, JButton button4, JButton button5) {
		// Sets the variables equal to their corresponding input or values
		super();
		player = person;
		player2 = person2;
		val = false;
		button = roll;
		turn = label1;
		label = new JLabel(player.getName() + ": 0", SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		label.setBorder(border);

		// Adds the label to the scoreboard
		super.add(label);

		// Creates an array of the buttons for each dice and an array of the buttons in
		// the scoreboard
		buttons = new JButton[5];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;
		buttons[3] = button4;
		buttons[4] = button5;
		arr = new JButton[13];
		arr[0] = ones;
		arr[1] = twos;
		arr[2] = threes;
		arr[3] = fours;
		arr[4] = fives;
		arr[5] = sixes;
		arr[6] = toak;
		arr[7] = foak;
		arr[8] = fh;
		arr[9] = ss;
		arr[10] = ls;
		arr[11] = chance;
		arr[12] = yahtzee;

		// Adds the scoreboard buttons and label2 to the scoreboard
		for (JButton o : arr) {
			o.setBorder(border);
			super.add(o);
		}
		super.add(label2);
		label2.setBorder(border);

		// Sets the layout for the scoreboard
		super.setLayout(new GridLayout(15, 1, 3, 3));
		boolean[] arr2 = { true, true, true, true, true };

		// For each button the corresponding function assigned
		ones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					ones.setText(String.valueOf(player.calcUpperSection(1)));
					player.setScore(player.calcUpperSection(1));
					ones.setEnabled(false);
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		twos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					twos.setText(String.valueOf(player.calcUpperSection(2)));
					player.setScore(player.calcUpperSection(2));
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					twos.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		threes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					threes.setText(String.valueOf(player.calcUpperSection(3)));
					player.setScore(player.calcUpperSection(3));
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					threes.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		fours.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					fours.setText(String.valueOf(player.calcUpperSection(4)));
					player.setScore(player.calcUpperSection(4));
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					fours.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		fives.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					fives.setText(String.valueOf(player.calcUpperSection(5)));
					player.setScore(player.calcUpperSection(5));
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					fives.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		sixes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					sixes.setText(String.valueOf(player.calcUpperSection(6)));
					player.setScore(player.calcUpperSection(6));
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					sixes.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		toak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					toak.setText(String.valueOf(player.calcThreeOfAKind()));
					player.setScore(player.calcThreeOfAKind());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					toak.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		foak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					foak.setText(String.valueOf(player.calcFourOfAKind()));
					player.setScore(player.calcFourOfAKind());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					foak.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		ss.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					ss.setText(String.valueOf(player.calcSmallStraight()));
					player.setScore(player.calcSmallStraight());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					ss.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		ls.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					ls.setText(String.valueOf(player.calcLargeStraight()));
					player.setScore(player.calcLargeStraight());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					ls.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		fh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					fh.setText(String.valueOf(player.calcFullHouse()));
					player.setScore(player.calcFullHouse());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					fh.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		chance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					chance.setText(String.valueOf(player.calcChance()));
					player.setScore(player.calcChance());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					chance.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
		yahtzee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (player.getTurn()) {
					player.changeTurn();
					player2.changeTurn();
					yahtzee.setText(String.valueOf(player.calcYahtzee()));
					player.setScore(player.calcYahtzee());
					player.increment();
					label.setText(player.getName() + ": " + player.getScore());
					yahtzee.setEnabled(false);
					button.setEnabled(true);
					button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setEnabled(true);
					button4.setEnabled(true);
					button5.setEnabled(true);
					turn.setText(player2.getName() + "'s Turn");
					val = true;
					count++;
					counter++;
					player2.roll(arr2);
					for (int j = 0; j < 5; j++) {
						buttons[j].setIcon(new ImageIcon("images/dice" + player2.getDiceNum(j) + ".png"));
					}
					if (player.getCounter() == 13) {
						if (Integer.parseInt(ones.getText()) + Integer.parseInt(twos.getText())
								+ Integer.parseInt(threes.getText()) + Integer.parseInt(fours.getText())
								+ Integer.parseInt(fives.getText()) + Integer.parseInt(sixes.getText()) >= 63) {
							player.setScore(35);
							label.setText(player.getName() + ": " + player.getScore());
							label2.setText("Bonus: 35");
						} else {
							label2.setText("Bonus: 0");
						}
					}
					if (player.getCounter() == 13 && player2.getCounter() == 13) {
						if (player.getScore() > player2.getScore()) {
							turn.setText(player.getName() + " Wins");
						} else {
							turn.setText(player2.getName() + " Wins");
						}
					}
				}
			}
		});
	}

	// Returns the value of counter
	public int getCounter() {
		return counter;
	}

	// Switches the turn
	public boolean turnSwitch() {
		boolean temp = val;
		val = false;
		return temp;
	}

	// Returns the value of count
	public int getCount() {
		return count;
	}
}
