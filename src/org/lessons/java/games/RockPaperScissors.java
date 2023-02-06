package org.lessons.java.games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		System.out.println("Welcome to Rock Paper Scissors!");
		Scanner scRPS = new Scanner(System.in);

		while (true) {
			System.out.println("Make your choice: Rock[r] Paper[p] Scissors[s]: ");
			String playerChoice = scRPS.nextLine();
			while (!playerChoice.equalsIgnoreCase("r") && !playerChoice.equalsIgnoreCase("p")
					&& !playerChoice.equalsIgnoreCase("s")) {
				System.out.print("Invalid input. Please enter 'r', 'p' or 's'. ");
				System.out.print("Make your choice: Rock[r] Paper[p] Scissors[s]: ");
				playerChoice = scRPS.nextLine();
			}

			String[] choices = { "r", "p", "s" };
			String computerChoice = choices[new Random().nextInt(choices.length)];

			printTurn("User", playerChoice);

			printTurn("Computer", computerChoice);

			getWinner(playerChoice, computerChoice);

			System.out.print("Do you want to play again? (y/n) ");
			String answer = scRPS.nextLine();
			while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Do you want to play again? (y/n) ");
				answer = scRPS.nextLine();
			}
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("Game closed.");
				break;
			}
		}
	}

	private static void printTurn(String player, String choice) {
		String playString = "";
		if (choice.equals("r")) {
			playString = "Rock";
		} else if (choice.equals("p")) {
			playString = "Paper";
		} else if (choice.equals("s")) {
			playString = "Scissors";
		}
		System.out.println(player + " played " + playString);
	}

	private static void getWinner(String playerChoice, String computerChoice) {
		if (playerChoice.equals(computerChoice)) {
			System.out.println("The game ended in a tie!");
		} else if (playerChoice.equals("r") && computerChoice.equals("p")) {
			System.out.println("Computer won!");
		} else if (playerChoice.equals("r") && computerChoice.equals("s")) {
			System.out.println("Player won!");
		} else if (playerChoice.equals("p") && computerChoice.equals("r")) {
			System.out.println("Player won!");
		} else if (playerChoice.equals("p") && computerChoice.equals("s")) {
			System.out.println("Computer won!");
		} else if (playerChoice.equals("s") && computerChoice.equals("r")) {
			System.out.println("Computer won!");
		} else if (playerChoice.equals("s") && computerChoice.equals("p")) {
			System.out.println("Player won!");
		}
	}

}
