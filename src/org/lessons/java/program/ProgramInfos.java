package org.lessons.java.program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramInfos {

	public static void main(String[] args) {
		System.out.println("This program has multiple functionalities to play with strings and numbers.");
		Scanner scPI = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.println("What do you want to know about? ");
			System.out.println("1. Number Checker");
			System.out.println("2. Calculator");
			System.out.println("3. Prime Numbers Calculator");
			System.out.println("4. Password Generator");
			System.out.println("5. String Manipulator");
			System.out.println("10. Back.");

			try {
				int choice = scPI.nextInt();
				scPI.nextLine();
				if (choice >= 1 && choice <= 10) {
					switch (choice) {
					case 1: // Number Checker
						System.out.println(
								"Number Checker è un programma che verifica diverse proprietà di un numero, tra cui se è pari o dispari, ");
						System.out.println(
								"se si tratta di un numero primo, se è perfetto/abbondante/deficitario, se è felice e altre.");
						System.out.println(
								"Inoltre calcola anche i suoi divisori, i suoi fattori primi e se è un quadrato perfetto.");
						System.out.println("Do you want to launch the Number Checker? (y/n)");
						String answer1 = scPI.nextLine();
						while (!answer1.equalsIgnoreCase("y") && !answer1.equalsIgnoreCase("n")) {
							System.out.print("Invalid input. Please enter 'y' or 'n'. ");
							System.out.print("Do you want to launch the Number Checker? (y/n)");
							answer1 = scPI.nextLine();
						}
						if (answer1.equalsIgnoreCase("y")) {
							NumberChecker.main(args);
						}
						break;
					case 2: // Calculator
						System.out.println(
								"Calculator è una semplice calcolatrice che permette di effettuare operazioni matematiche di base come");
						System.out.println("addizione, sottrazione, moltiplicazione, divisione, modulo e potenza.");
						System.out.println("Do you want to launch the Calculator? (y/n)");
						String answer2 = scPI.nextLine();
						while (!answer2.equalsIgnoreCase("y") && !answer2.equalsIgnoreCase("n")) {
							System.out.print("Invalid input. Please enter 'y' or 'n'. ");
							System.out.print("Do you want to launch the Calculator? (y/n)");
							answer2 = scPI.nextLine();
						}
						if (answer2.equalsIgnoreCase("y")) {
							Calculator.main(args);
						}
						break;
					case 3: // Prime Numbers Calculator
						System.out.println(
								"Prime Numbers Calculator è un programma che permette di individuare un certo numero di numeri primi,");
						System.out.println(
								"deciso dall'utente. E' possibile anche impostare il numero iniziale da cui iniziare a contare.");
						System.out.println("Do you want to launch the Prime Numbers Calculator? (y/n)");
						String answer3 = scPI.nextLine();
						while (!answer3.equalsIgnoreCase("y") && !answer3.equalsIgnoreCase("n")) {
							System.out.print("Invalid input. Please enter 'y' or 'n'. ");
							System.out.print("Do you want to launch the Prime Numbers Calculator? (y/n)");
							answer3 = scPI.nextLine();
						}
						if (answer3.equalsIgnoreCase("y")) {
							PrimeCalculator.main(args);
						}
						break;
					case 4: // Password Generator
						System.out.println(
								"Password Generator è un programma che permette di creare delle password. E' possibile decidere se utilizzare");
						System.out.println(
								"dei caratteri speciali, dei numeri e/o una stringa specifica da inserire nella generazione della password.");
						System.out.println("Do you want to launch the Password Generator? (y/n)");
						String answer4 = scPI.nextLine();
						while (!answer4.equalsIgnoreCase("y") && !answer4.equalsIgnoreCase("n")) {
							System.out.print("Invalid input. Please enter 'y' or 'n'. ");
							System.out.print("Do you want to launch the Password Generator? (y/n)");
							answer4 = scPI.nextLine();
						}
						if (answer4.equalsIgnoreCase("y")) {
							PasswordGenerator.main(args);
						}
						break;
					case 5: // String Manipulator
						System.out.println(
								"String Manipulator è un programma che permette di inserire una stringa per effettuare diverse manipolazioni e controlli.");
						System.out.println(
								"Il programma ritorna la stringa rovesciata, senza vocali, senza consonanti, senza spazi, ecc...");
						System.out.println(
								"Inoltre conta da quante parole è composta la stringa, da quanti caratteri, e controlla se è palindroma.");
						System.out.println("Do you want to launch the String Manipulator? (y/n)");
						String answer5 = scPI.nextLine();
						while (!answer5.equalsIgnoreCase("y") && !answer5.equalsIgnoreCase("n")) {
							System.out.print("Invalid input. Please enter 'y' or 'n'. ");
							System.out.print("Do you want to launch the String Manipulator? (y/n)");
							answer5 = scPI.nextLine();
						}
						if (answer5.equalsIgnoreCase("y")) {
							StringManipulator.main(args);
						}
						break;
					case 10: // Quit the program
						System.out.println("Back to the functions list!");
						return;
					}
				} else {
					System.out.println("Invalid choice. Try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice. Use suggested numbers to insert a correct input.");
				scPI.next();
			}

		}

		repeat = false;
	}
}
