package org.lessons.java.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberChecker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean repeat = true;
		int number = 0;
		while (repeat) {
			boolean inputValid = false;
			while (!inputValid) {
				try {
					System.out.print("Insert a positive integer: ");
					number = scan.nextInt();
					if (number >= 0) {
						System.out.println(" ");
						inputValid = true;
					} else {
						System.out.println("The number must be positive. Try again.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Try again.");
					scan.nextLine();
				}
			}

			// Controllo se il numero è pari o dispari
			if (number % 2 == 0) {
				System.out.println(number + " is an even number.");
			} else {
				System.out.println(number + " is an odd number.");
			}

			// Controllo se il numero è primo
			boolean isPrime = true;
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.println(number + " is a prime number.");
			} else {
				System.out.println(number + " is not a prime number.");
			}

			// Trova i divisori del numero
			System.out.print("All divisors of " + number + " are: ");
			ArrayList<Integer> divisors = new ArrayList<>();
			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					divisors.add(i);
				}
			}
			Collections.sort(divisors);
			for (int divisor : divisors) {
				System.out.print(divisor + " ");
			}
			System.out.println();

			// Scomposizione in fattori primi
			int factor = number;
			System.out.print("All prime factors of " + factor + " are: ");
			for (int i = 2; i <= factor; i++) {
				while (factor % i == 0) {
					System.out.print(i + " ");
					factor /= i;
				}
			}
			System.out.println();

			// Controllo se il numero è un numero felice
			int n = number;
			HashSet<Integer> seen = new HashSet<>();
			while (n != 1 && !seen.contains(n)) {
				seen.add(n);
				int sum = 0;
				while (n > 0) {
					int digit = n % 10;
					sum += digit * digit;
					n /= 10;
				}
				n = sum;
			}
			if (n == 1) {
				System.out.println(number + " is an happy number.");
			} else {
				System.out.println(number + " is not an happy number.");
			}

			// Controllo se il numero è perfetto
			int sum = 0;
			for (int i = 1; i < number; i++) {
				if (number % i == 0) {
					sum += i;
				}
			}
			if (sum == number) {
				System.out.println(number + " is a perfect number.");
			} else if (sum > number) {
				System.out.println(number + " is an abundant number.");
			} else {
				System.out.println(number + " is a deficit number.");
			}

			// Controllo se il numero è un quadrato perfetto
			double sqrt = Math.sqrt(number);
			if (sqrt == Math.floor(sqrt)) {
				System.out.println(number + " is a perfect square.");
			} else {
				System.out.println(number + " is not a perfect square.");
			}

			boolean repeat1 = true;
			boolean control = true;
			while (repeat1) {
				System.out.println("Do you want to check another number?");
				System.out.println("1. Yes");
				System.out.println("2. No");

				control = true;

				while (control) {
					try {
						int answer = scan.nextInt();
						if (answer == 1 || answer == 2) {
							if (answer == 2) {
								repeat1 = false;
								control = false;
								repeat = false;
								System.out.println("Number Checker closed!");
							}
							control = false;
							repeat1 = false;
							break;
						} else {
							System.out.println("Invalid input. Please enter 1 for 'Yes' or 2 for 'No'.");
							scan.nextLine();
							control = false;
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid input. Please enter 1 for 'Yes' or 2 for 'No'.");
						scan.nextLine();
						control = false;
					}
				}
			}

		}
		// scan.close();

	}
}
