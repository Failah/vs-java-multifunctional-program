package org.lessons.java.games;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe!");
		Scanner scanner = new Scanner(System.in);
		boolean repeat = false;

		while (!repeat) {
			String choice = "";
			while (true) {
				System.out.println("Choose game mode (1/2) or close the game (3): ");
				System.out.println("1. Player vs Player.");
				System.out.println("2. Player vs Computer.");
				System.out.println("3. Quit the game.");
				choice = scanner.nextLine();
				if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
					System.out.println("Please enter a valid input!");
				} else {
					break;
				}
			}

			char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

			// PLAYER VS PLAYER MODE
			if (choice.equals("1")) {

				System.out.println("Player 'X' enter you name: ");
				String playerX = scanner.nextLine();
				while (playerX == null || playerX.isEmpty()) {
					System.out.println("Player name cannot be empty!");
					System.out.println("Player 'X' enter you name: ");
				}
				System.out.println("Player 'O' enter you name: ");
				String playerO = scanner.nextLine();
				if (playerO == null || playerO.isEmpty()) {
					System.out.println("Player name cannot be empty!");
					continue;
				}

				printBoard(board);
				while (true) {
					System.out.print("It's " + playerX + "'s turn! ");
					playerTurn(board, scanner, 'X');
					if (isGameFinished(board, playerX, playerO)) {
						break;
					}
					printBoard(board);
					System.out.print("It's " + playerO + "'s turn! ");
					playerTurn(board, scanner, 'O');
					if (isGameFinished(board, playerX, playerO)) {
						break;
					}
					printBoard(board);
				}
				repeat = !playAgain(scanner);

				// PLAYER VS COMPUTER MODE
			} else if (choice.equals("2")) {
				printBoard(board);
				while (true) {
					playerTurn(board, scanner, 'X');
					if (isGameFinished(board, "Player", "Computer")) {
						break;
					}
					printBoard(board);
					computerTurn(board);
					if (isGameFinished(board, "Player", "Computer")) {
						break;
					}
					printBoard(board);
				}
				repeat = !playAgain(scanner);

				// CLOSE THE GAME OPTION 3
			} else if (choice.equals("3")) {
				System.out.println("Game closed.");
				repeat = true;
			}
		}
		// scanner.close();
	}

	public static boolean playAgain(Scanner scanner) {
		System.out.println("Would you like to play again? (y/n) ");
		String playAgain = scanner.nextLine();
		while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n")) {
			System.out.print("Invalid input. Please enter 'y' or 'n'. ");
			System.out.print("Would you like to play again? (y/n) ");
			playAgain = scanner.nextLine();
		}
		if (playAgain.equalsIgnoreCase("n")) {
			System.out.println("Game closed.");
			return false;
		}
		return true;
	}

	private static boolean isGameFinished(char[][] board, String playerX, String playerO) {

		if (hasContestantWon(board, 'X')) {
			printBoard(board);
			System.out.println(playerX + " wins!");
			return true;
		}

		if (hasContestantWon(board, 'O')) {
			printBoard(board);
			System.out.println(playerO + " wins!");
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}

	private static boolean hasContestantWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
				|| (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
				|| (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
				|| (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
				|| (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
				|| (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			return true;
		}
		return false;
	}

	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(board, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove + "!");
		placeMove(board, Integer.toString(computerMove), 'O');
	}

	private static boolean isValidMove(char[][] board, String position) {
		switch (position) {
		case "1":
			return (board[0][0] == ' ');
		case "2":
			return (board[0][1] == ' ');
		case "3":
			return (board[0][2] == ' ');
		case "4":
			return (board[1][0] == ' ');
		case "5":
			return (board[1][1] == ' ');
		case "6":
			return (board[1][2] == ' ');
		case "7":
			return (board[2][0] == ' ');
		case "8":
			return (board[2][1] == ' ');
		case "9":
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}

	private static void playerTurn(char[][] board, Scanner scanner, char symbol) {
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if (isValidMove(board, userInput)) {
				break;
			} else {
				System.out.println(userInput + " is not a valid move.");
			}
		}
		placeMove(board, userInput, symbol);
	}

	private static void placeMove(char[][] board, String position, char symbol) {
		switch (position) {
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println(":(");
		}
	}

	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}

}
