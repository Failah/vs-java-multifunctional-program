package org.lessons.java.games;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.lessons.java.snakegame.SnakeGame;

public class GameHub {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the Game Hub!");
		Scanner scGH = new Scanner(System.in);

		while (true) {
			System.out.println("What do you want to play?");
			System.out.println("1. Tic Tac Toe.");
			System.out.println("2. Rock Paper Scissors.");
			System.out.println("3. The Hangman Game.");
			System.out.println("4. Snake Game.");
			System.out.println("10. Quit the Game Hub.");

			if (scGH.hasNextInt()) {
				int gameChoice = scGH.nextInt();
				scGH.nextLine();
				if (gameChoice >= 1 && gameChoice <= 10) {
					switch (gameChoice) {
					case 1:
						System.out.println("");
						TicTacToe.main(args);
						break;
					case 2:
						System.out.println("");
						RockPaperScissors.main(args);
						break;
					case 3:
						System.out.println("");
						HangmanGame.main(args);
						break;
					case 4:
						System.out.println("");
						System.out.println("This game is still in development, although is already playable.");
						System.out.println(
								"Running this game will close the entire program [this will be fixed eventually in the future].");
						while (true) {
							System.out.println("Would you like to launch Snake? (y/n) ");
							String playSnake = scGH.nextLine();
							if (!playSnake.equalsIgnoreCase("y") && !playSnake.equalsIgnoreCase("n")) {
								System.out.println("Invalid input. Please use 'y' or 'n' to make your decision.");
							} else if (playSnake.equalsIgnoreCase("n")) {
								break;
							} else {
								SnakeGame.main(args);
								System.out.println("Program closed.");
								return;
							}
						}
						break;
					case 10: // Quit the game hub
						System.out.println("Back to the functions list!");
						return;
					}
				} else {
					System.out.println("Invalid choice. Try again.");
				}
			} else {
				System.out.println("Invalid input. Try again.");
				scGH.nextLine();
			}
		}
	}

}
