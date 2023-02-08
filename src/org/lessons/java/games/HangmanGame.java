package org.lessons.java.games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) throws FileNotFoundException {

		boolean play = true;

		while (play) {
			Scanner keyboard = new Scanner(System.in);

			System.out.println("Enter the number of players: (1 or 2) ");
			String player = keyboard.nextLine();
			String randomWord;

			while (!player.equals("1") && !player.equals("2")) {
				System.out.println("Invalid input. Please type '1' or '2' to make your selection.");
				System.out.println("Enter the number of players: (1 or 2) ");
				player = keyboard.nextLine();
			}

			if (player.equals("1")) {

				Scanner scanner = new Scanner(new File(
						"C:/Users/Valerio/Desktop/Boolean/Java/Workspace1/vs-java-multifunctional-program/src/org/lessons/java/games/paroletest.txt"));
				List<String> wordsList = new ArrayList<>();

				while (scanner.hasNextLine()) {
					wordsList.add(scanner.nextLine().toLowerCase());
				}

				Random rand = new Random();

				randomWord = wordsList.get(rand.nextInt(wordsList.size()));
			} else {
				System.out.println("Player 1, enter you word: ");
				randomWord = keyboard.nextLine();
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("Player 2 to play!");
			}

			// System.out.println(randomWord);

			List<Character> userGuesses = new ArrayList<>();

			writeWord(randomWord, userGuesses);

			int wrongGuessesCounter = 0;
			while (true) {

				drawHangman(wrongGuessesCounter);
				if (userGuesses.size() > 0) {
					System.out.print("Letters you already guessed: ");
					for (char letter : userGuesses) {
						System.out.print(letter + " ");
					}
					System.out.println();
				}

				if (wrongGuessesCounter >= 6) {
					System.out.println("You lost!");
					System.out.println("The word was: " + randomWord);
					System.out.print("Do you want to play again? (y/n) ");
					String answer = keyboard.nextLine();
					while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
						System.out.print("Invalid input. Please enter 'y' or 'n'. ");
						System.out.print("Do you want to play again? (y/n) ");
						answer = keyboard.nextLine();
					}
					if (answer.equalsIgnoreCase("n")) {
						System.out.println("Game closed.");
						play = false;
						break;
					} else {
						break;
					}
				}

				if (!getPlayerGuess(keyboard, randomWord, userGuesses)) {
					wrongGuessesCounter++;
				}

				if (writeWord(randomWord, userGuesses)) {
					System.out.println("You won!");
					System.out.print("Do you want to play again? (y/n) ");
					String answer = keyboard.nextLine();
					while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
						System.out.print("Invalid input. Please enter 'y' or 'n'. ");
						System.out.print("Do you want to play again? (y/n) ");
						answer = keyboard.nextLine();
					}
					if (answer.equalsIgnoreCase("n")) {
						System.out.println("Game closed.");
						play = false;
						break;
					} else {
						break;
					}
				}
			}
		}
	}

	private static boolean getPlayerGuess(Scanner keyboard, String randomWord, List<Character> userGuesses) {
		System.out.println("Enter a guessed letter: ");
		String guessedLetter = keyboard.nextLine();
		while (userGuesses.contains(guessedLetter.charAt(0))) {
			System.out.println("You already picked the letter '" + guessedLetter + "'. Pick another letter!");

			System.out.print("Letters you already guessed: ");
			for (char letter : userGuesses) {
				System.out.print(letter + " ");
			}
			System.out.println();
			System.out.println("Enter a guessed letter: ");
			guessedLetter = keyboard.nextLine();
		}
		userGuesses.add(guessedLetter.charAt(0));

		return randomWord.contains(guessedLetter);
	}

	private static boolean writeWord(String randomWord, List<Character> userGuesses) {
		int correctCounter = 0;
		System.out.println("Find the word:");
		for (int i = 0; i < randomWord.length(); i++) {
			if (userGuesses.contains(randomWord.charAt(i))) {
				System.out.print(randomWord.charAt(i));
				correctCounter++;
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
		return (randomWord.length() == correctCounter);
	}

	private static void drawHangman(int wrongGuessesCounter) {
		if (wrongGuessesCounter == 0) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter == 1) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println("         |");
			System.out.println("         |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter == 2) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println("  |      |");
			System.out.println("         |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter == 3) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println(" /|      |");
			System.out.println("         |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter == 4) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println(" /|\\     |");
			System.out.println("         |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter == 5) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println(" /|\\     |");
			System.out.println(" /       |");
			System.out.println("         |");
		}
		if (wrongGuessesCounter >= 6) {
			System.out.println("  ________");
			System.out.println("  |      |");
			System.out.println("  O      |");
			System.out.println(" /|\\     |");
			System.out.println(" / \\     |");
			System.out.println("         |");
		}
	}
}