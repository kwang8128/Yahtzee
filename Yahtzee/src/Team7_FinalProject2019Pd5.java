/*
 * Program Purpose: Final Project for AP CS, a Yahtzee game
 * Names: Kai Wang and Sathvik Inteti, Team 7
 * Date: 6/8/19
 * Period: 5
 * Revision #: 1
 */

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Team7_FinalProject2019Pd5 {

	public static void main(String[] args) {
		// Initializes all elements of the GUI except for the scoreboard and sets the characteristics for each element
		JFrame frame = new JFrame("Yahtzee");
		JFrame instruction = new JFrame("Instructions");
		JButton button1 = new JButton(new ImageIcon("images/dice1.png"));
		JButton button2 = new JButton(new ImageIcon("images/dice2.png"));
		JButton button3 = new JButton(new ImageIcon("images/dice3.png"));
		JButton button4 = new JButton(new ImageIcon("images/dice4.png"));
		JButton button5 = new JButton(new ImageIcon("images/dice5.png"));
		JButton button6 = new JButton("Roll Selected");
		JButton instructions = new JButton("Instructions");
		ArrayList<Person> playerList = new ArrayList<Person>();
		playerList.add(new Person("Jack"));
		playerList.add(new Person("Jill"));
		JLabel label = new JLabel(playerList.get(0).getName() + "'s Turn", SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		label.setBorder(border);
		JLabel instruct = new JLabel(
				"<html><center>Instruction for Yahtzee<br>The rules of this game are similar to the rules of Yahtzee. However, due to time constraints, we did not implement the joker rules in the Yahtzee game.<br>"
						+ "<br>"
						+ "Each player plays this game until all the categories are filled up. During each round, you try to score one category. Each round consists of 2 phases. The first phase involves rolling the dice. After the first roll, you can choose to reroll any of the dice. You can do this again after the second roll, but not the third roll. You can choose to score your hand any time you wish after the first/second roll, but by the third roll, the dice will be grayed out and you must score your hand. Click on the category you want to score. When scoring your hand, keep in mind that you can only pick each category once throughout the game. If the category does not apply to the hand, the player gets a score of 0 for that category.<br>"
						+ "<br>" + "The categories are the following:<br>" + "<br>" + "Upper Section:<br>"
						+ "Aces: the score is the sum of all dice showing a value of 1.<br>"
						+ "Twos: the score is the sum of all dice showing a value of 2.<br>"
						+ "Threes: the score is the sum of all dice showing a value of 3.<br>"
						+ "Fours: the score is the sum of all dice showing a value of 4.<br>"
						+ "Fives: the score is the sum of all dice showing a value of 5.<br>"
						+ "Sixes: the score is the sum of all dice showing a value of 6.<br>" + "<br>"
						+ "If the player scores at least a 63 on the upper section, the player gets a bonus of 35 points added to their final score.<br>"
						+ "<br>" + "Lower section:<br>"
						+ "Three of a kind: at least three of the dice have the same value, the score is the sum of all dice<br>"
						+ "Four of a kind: at least four of the dice have the same value, the score is the sum of all dice<br>"
						+ "Full house: three of the dice have the same value, and the remaining two dice have the same value, but not the same as the other 3 dice, 25 points<br>"
						+ "Small Straight: four sequential dice (1-2-3-4, 2-3-4-5, or 3-4-5-6), 30 points<br>"
						+ "Large Straight: five sequential dice (1-2-3-4-5, or 2-3-4-5-6), 40 points<br>"
						+ "Yahtzee: all the dice have the same value, 50 points<br>"
						+ "Chance: any combination, the score is the sum of all dice<br></center></html>" + "",
				SwingConstants.CENTER);
		button1.setBorder(border);
		button2.setBorder(border);
		button3.setBorder(border);
		button4.setBorder(border);
		button5.setBorder(border);
		button6.setBorder(border);
		JPanel panel = new JPanel();
		Scoreboard scoreboard = new Scoreboard(playerList.get(0), playerList.get(1), label, button6, button1, button2,
				button3, button4, button5);
		Scoreboard scoreboard2 = new Scoreboard(playerList.get(1), playerList.get(0), label, button6, button1, button2,
				button3, button4, button5);
		JPanel panel2 = new JPanel();
		panel.setLayout(new GridLayout(8, 1, 3, 3));
		panel2.setLayout(new GridLayout(1, 3, 3, 3));

		// Changes the turn to player 1's turn
		playerList.get(0).changeTurn();

		// Adds elements to the panel that will contain each of the dice, the roll
		// button, and the instructions button
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(instructions);

		// Adds every other panel to a central panel
		panel2.add(panel);
		panel2.add(scoreboard);
		panel2.add(scoreboard2);

		// Adds the label with instructions to the instruction frame
		instruction.add(instruct);

		// Adds the central panel to the frame and sets the characteristics of the frame
		frame.setSize(450, 1000);
		frame.add(panel2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Sets the characteristics of the instruction frame
		instruction.setSize(1000, 600);
		instruction.setVisible(false);
		instruction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initializes an array with each dice button
		JButton[] buttons = new JButton[6];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;
		buttons[3] = button4;
		buttons[4] = button5;

		// Creates arrays with booleans in them to simulate rolling the dice as well as
		// a counter to count whether two rolls have occured or not
		boolean[] arr = { false, false, false, false, false };
		boolean[] arr2 = { false };
		int[] count = { 0 };

		// Updates the images of the dice buttons
		for (int j = 0; j < 5; j++) {
			buttons[j].setIcon(new ImageIcon("images/dice"
					+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(j) + ".png"));
		}

		// For each button the corresponding element in the boolean array is changed, if
		// the button is clicked twice it will return to the original state
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr[0] = !arr[0];
				if (arr[0]) {
					button1.setIcon(new ImageIcon("images/idice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(0)
							+ ".png"));
				} else {
					button1.setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(0)
							+ ".png"));
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr[1] = !arr[1];
				if (arr[1]) {
					button2.setIcon(new ImageIcon("images/idice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(1)
							+ ".png"));
				} else {
					button2.setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(1)
							+ ".png"));
				}
			}
		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr[2] = !arr[2];
				if (arr[2]) {
					button3.setIcon(new ImageIcon("images/idice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(2)
							+ ".png"));
				} else {
					button3.setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(2)
							+ ".png"));
				}
			}
		});
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr[3] = !arr[3];
				if (arr[3]) {
					button4.setIcon(new ImageIcon("images/idice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(3)
							+ ".png"));
				} else {
					button4.setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(3)
							+ ".png"));
				}
			}
		});
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr[4] = !arr[4];
				if (arr[4]) {
					button5.setIcon(new ImageIcon("images/idice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(4)
							+ ".png"));
				} else {
					button5.setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(4)
							+ ".png"));
				}
			}
		});

		// Rolls the boolean array using the roll method in the setOfDice class and
		// checks whether conditions are met in order to stop a person from rolling more
		// than 2 times
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (scoreboard.turnSwitch() || scoreboard2.turnSwitch()) {
					count[0] = 0;
				}
				count[0]++;
				playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).roll(arr);
				for (int j = 0; j < 5; j++) {
					buttons[j].setIcon(new ImageIcon("images/dice"
							+ playerList.get((scoreboard.getCount() + scoreboard2.getCount()) % 2).getDiceNum(j)
							+ ".png"));
					arr[j] = false;
				}
				if (count[0] == 2) {
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
					button5.setEnabled(false);
					button6.setEnabled(false);
					count[0] = 0;
				}
			}
		});
		// Opens the instruction frame when the instructions button is pressed
		instructions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				arr2[0] = !arr2[0];
				if (arr2[0]) {
					instructions.setText("Close Instructions");
					instruction.setVisible(true);
				} else {
					instructions.setText("Instructions");
					instruction.setVisible(false);
				}
			}
		});
	}
}
