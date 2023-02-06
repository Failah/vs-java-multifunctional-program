package org.lessons.java.program;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.lessons.java.games.GameHub;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("What do you want to do?");
			System.out.println("0. What is this program about?");
			System.out.println("1. Launch the Number Checker.");
			System.out.println("2. Launch the Calculator.");
			System.out.println("3. Launch the Prime Numbers Calculator.");
			System.out.println("4. Launch the Password Generator.");
			System.out.println("5. Launch the String Manipulator.");
			System.out.println("6. Enter the Game Hub.");
			System.out.println("10. Quit the program.");
			if (s.hasNextInt()) {
				int choice = s.nextInt();
				s.nextLine();
				if (choice >= 0 && choice <= 10) {
					switch (choice) {
					case 0:
						System.out.println("");
						ProgramInfos.main(args);
						break;
					case 1:
						System.out.println("");
						NumberChecker.main(args);
						break;
					case 2:
						System.out.println("");
						Calculator.main(args);
						break;
					case 3:
						System.out.println("");
						PrimeCalculator.main(args);
						break;
					case 4:
						System.out.println("");
						PasswordGenerator.main(args);
						break;
					case 5:
						System.out.println("");
						StringManipulator.main(args);
						break;
					case 6:
						System.out.println("");
						GameHub.main(args);
						break;
					case 10:
						System.out.println("");
						System.out.println("Program closed!");
						s.close();
						return;
					}
				} else {
					System.out.println("Invalid choice. Try again.");
				}
			} else {
				System.out.println("Invalid input. Try again.");
				s.nextLine();
			}

		}

	}

}
