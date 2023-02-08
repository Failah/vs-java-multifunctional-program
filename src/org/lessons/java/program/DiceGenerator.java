package org.lessons.java.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DiceGenerator {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Generator!");
		while (true) {
			Scanner scDG = new Scanner(System.in);
			String launches;
			String choice;
			while (true) {
				System.out.println("What do you want to do?");
				System.out.println("0. Launch a coin (Heads or Tails).");
				System.out.println("1. Launch D3.");
				System.out.println("2. Launch D4.");
				System.out.println("3. Launch D6.");
				System.out.println("4. Launch D8.");
				System.out.println("5. Launch D10.");
				System.out.println("6. Launch D12.");
				System.out.println("7. Launch D20.");
				System.out.println("8. Launch D100.");
				System.out.println("9. Launch dice for each value.");
				choice = scDG.nextLine();
				if (!choice.equals("0") && !choice.equals("1") && !choice.equals("2") && !choice.equals("3")
						&& !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")
						&& !choice.equals("8") && !choice.equals("9")) {
					System.out.println("Invalid input. Please use numbers to select your choise.");
				} else {
					break;
				}
			}
			while (true) {
				System.out.println("How many launches do you want to do? (max 10) ");
				launches = scDG.nextLine();
				if (!launches.equals("1") && !launches.equals("2") && !launches.equals("3") && !launches.equals("4")
						&& !launches.equals("5") && !launches.equals("6") && !launches.equals("7")
						&& !launches.equals("8") && !launches.equals("9") && !launches.equals("10")) {
					System.out.println("Invalid input. Please use numbers (1-10) to select the number of launches.");
				} else {
					break;
				}
			}

			int counter;
			String die;
			switch (choice) {
			case "0":
				counter = 2;
				die = "coin";
				launchDice(launches, counter, die);
				break;
			case "1":
				counter = 3;
				die = "D3";
				launchDice(launches, counter, die);
				break;
			case "2":
				counter = 4;
				die = "D4";
				launchDice(launches, counter, die);
				break;
			case "3":
				counter = 6;
				die = "D6";
				launchDice(launches, counter, die);
				break;
			case "4":
				counter = 8;
				die = "D8";
				launchDice(launches, counter, die);
				break;
			case "5":
				counter = 10;
				die = "D10";
				launchDice(launches, counter, die);
				break;
			case "6":
				counter = 12;
				die = "D12";
				launchDice(launches, counter, die);
				break;
			case "7":
				counter = 20;
				die = "D20";
				launchDice(launches, counter, die);
				break;
			case "8":
				counter = 100;
				die = "D100";
				launchDice(launches, counter, die);
				break;
			case "9":
				List<Integer> counters = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 8, 10, 12, 20, 100));
				for (int element : counters) {
					die = "D" + element;
					launchDice(launches, element, die);
					System.out.println();
				}
				break;
			}

			System.out.print("Do you want to launch some dice again? (y/n) ");
			String answer = scDG.nextLine();
			while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Do you want to launch some dice again? (y/n) ");
				answer = scDG.nextLine();
			}
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("Program closed.");
				break;
			}
		}
	}

	private static void launchDice(String launches, int counter, String die) {
		Random random = new Random();
		for (int i = 0; i < Integer.parseInt(launches); i++) {
			int value = random.nextInt(counter) + 1;
			if (counter == 2) {
				String headsOrTails;
				if (value == 1) {
					headsOrTails = "heads";
				} else {
					headsOrTails = "tails";
				}
				System.out.println(i + 1 + ") Random coin value: " + headsOrTails);
			} else {
				System.out.println(i + 1 + ") Random " + die + " value: " + value);
			}
		}
	}

}
