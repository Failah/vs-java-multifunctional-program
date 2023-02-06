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
			Scanner scanner = new Scanner(new File(
					"C:/Users/Valerio/Desktop/Boolean/Java/Workspace1/vs-java-multifunctionl-program/src/org/lessons/java/games/paroletest.txt"));
			List<String> wordsList = new ArrayList<>();

			while (scanner.hasNextLine()) {
				wordsList.add(scanner.nextLine().toLowerCase());
			}

			Random rand = new Random();

			String randomWord = wordsList.get(rand.nextInt(wordsList.size()));

			System.out.println(randomWord);

			List<Character> userGuesses = new ArrayList<>();

			writeWord(randomWord, userGuesses);

			int wrongGuessesCounter = 0;
			while (true) {

				drawHangman(wrongGuessesCounter);

				if (wrongGuessesCounter >= 6) {
					System.out.println("You lost!");
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
		userGuesses.add(guessedLetter.charAt(0));

		return randomWord.contains(guessedLetter);
	}

	private static boolean writeWord(String randomWord, List<Character> userGuesses) {
		int correctCounter = 0;
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