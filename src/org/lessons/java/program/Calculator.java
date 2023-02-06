package org.lessons.java.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal[] numbers = new BigDecimal[10];
		boolean repeat = true;

		while (repeat) {
			String operatorName = "";
			boolean divisionByZeroCheck = false;

			System.out.print("Enter the number of values you want to perform the operation on (maximum 10): ");
			int numberOfValues = getNumber(sc);

			System.out.print("Choose an operation (+, -, *, /, %, ^, #(all operations [need fix]) ): ");
			System.out.println();
			char operator = getOperator(sc);

			String operatorString = Character.toString(operator);
			if (operatorString.equals("-")) {
				System.out
						.println("In subtraction, all other numbers will be subtracted from the first number entered.");
			}

			System.out.println("Enter the values: ");
			for (int i = 0; i < numberOfValues; i++) {
				System.out.print("Value " + (i + 1) + ": ");
				try {
					numbers[i] = sc.nextBigDecimal();
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Enter an integer.");
					sc.next();
					i--;
				}
			}

			BigDecimal result = numbers[0];
			for (int i = 1; i < numberOfValues; i++) {
				switch (operator) {
				case '+':
					operatorName = "addition";
					result = result.add(numbers[i]);
					break;
				case '-':
					operatorName = "subtraction";
					result = result.subtract(numbers[i]);
					break;
				case '*':
					operatorName = "multiplication";
					result = result.multiply(numbers[i]);
					break;
				case '/':
					if (numbers[i].compareTo(BigDecimal.ZERO) == 0) {
						System.out.println("Error: division by zero is not allowed.");
						divisionByZeroCheck = true;
						break;
					}
					operatorName = "division";
					BigDecimal bdResult = new BigDecimal(result.doubleValue() / numbers[i].doubleValue());
					int scale = 0;
					boolean validInput = false;
					while (!validInput) {
						System.out.print("Enter number of decimal places: ");
						try {
							scale = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
							if (scale < 0) {
								System.out.println("Error: Invalid input. Decimal places cannot be negative.");
							} else {
								validInput = true;
							}
						} catch (NumberFormatException e) {
							System.out.println("Error: Invalid input. Decimal places must be a number.");
						} catch (IOException e) {
							System.out.println("Error: Invalid input.");
						}
					}
					result = bdResult.setScale(scale, RoundingMode.HALF_UP);
					break;
				case '%':
					operatorName = "module";
					result = result.remainder(numbers[i]);
					break;
				case '^':
					operatorName = "exponentiation";
					result = result.pow(numbers[i].intValue());
					break;
				// case '#':
				// result = performAllOperations(numbers, result, i);
				// break;
				}
			}

			if (!divisionByZeroCheck) {
				System.out.printf("The result of the " + operatorName + " is: " + result + "\n");
			}

			System.out.print("Do you want to perform another operation (y/n)? ");
			while (true) {
				try {
					String choice = sc.next();
					if (!choice.equals("y") && !choice.equals("n")) {
						System.out.println("Invalid input. Enter either 'y' or 'n'.");
						System.out.print("Do you want to perform another operation (y/n)? ");
						continue;
					} else {
						if (choice.equals("n")) {
							System.out.println("Calculator closed!");
							repeat = false;
							break;
						}
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Enter either 'y' or 'n'.");
					System.out.print("Do you want to perform another operation (y/n)? ");
					sc.next();
				}
			}
		}
	}

	private static int getNumber(Scanner sc) {
		while (true) {
			try {
				int number = sc.nextInt();
				if (number >= 2 && number <= 10) {
					return number;
				} else {
					System.out.println("The number must be between 2 and 10 (inclusive).");
					System.out.print("Enter the number of values: ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Enter an integer.");
				System.out.print("Enter the number of values: ");
				sc.next();
			}
		}
	}

	private static char getOperator(Scanner sc) {
		while (true) {
			String operator = sc.next();
			if (operator.length() == 1 && "+-*/%^#".contains(operator)) {
				return operator.charAt(0);
			} else {
				System.out.println("Invalid operator. Enter one of the following: +, -, *, /, %, ^");
				System.out.print("Choose an operation: ");
			}
		}
	}

	private static double performAllOperations(double[] numbers, double result, int i) {

		double sum = 0;
		double product = 1;

		for (double number : numbers) {
			sum += number;
			product *= number;
		}

		System.out.println("La somma di tutti i numeri è: " + sum);
		System.out.println("Il prodotto di tutti i numeri è: " + product);

		// sum
		for (int j = 1; j < numbers.length; j++) {
			result += numbers[j];
		}
		System.out.println("The sum is " + result);

		// difference
		for (int j = 1; j < numbers.length; j++) {
			result -= numbers[j];
		}
		System.out.println("The difference is " + result);

		// product
		for (int j = 1; j < numbers.length; j++) {
			result *= numbers[j];
		}
		System.out.println("The product is " + result);

		// division
		for (int j = 1; j < numbers.length; j++) {
			result /= numbers[j];
		}
		System.out.println("The division is " + result);

		// module
		for (int j = 1; j < numbers.length; j++) {
			result %= numbers[j];
		}
		System.out.println("The module is " + result);

		// pow
		for (int j = 1; j < numbers.length; j++) {
			result = Math.pow(result, numbers[j]);
		}
		System.out.println("The pow is " + result);
		return result;
	}
}
