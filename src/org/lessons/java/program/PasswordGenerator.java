package org.lessons.java.program;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String password = "";

		while (true) {
			System.out.println("Enter the length of the password: ");
			int length;
			while (true) {
				try {
					length = input.nextInt();
					if (length > 0) {
						break;
					} else {
						System.out.println("The number must be a positive integer and cannot be 0.");
						System.out.print("Enter the number of values: ");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Enter a positive integer.");
					System.out.print("Enter the number of values: ");
					input.next();
				}
			}
			input.nextLine();

			System.out.println("Include special characters? (y/n) ");
			String specialChar = input.nextLine();
			while (!specialChar.equalsIgnoreCase("y") && !specialChar.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Include special characters? (y/n) ");
				specialChar = input.nextLine();
			}

			System.out.println("Include numbers? (y/n) ");
			String includeNum = input.nextLine();
			while (!includeNum.equalsIgnoreCase("y") && !includeNum.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Include numbers? (y/n) ");
				includeNum = input.nextLine();
			}

			System.out.println("Enter one string to include in the password (or press enter to skip): ");
			String includeString = input.nextLine().trim();
			System.out.println("Include the string at the beginning, middle, or end? (b/m/e) (need fixing)");
			String position = input.nextLine();

			String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			if (includeNum.equals("y")) {
				chars += "0123456789";
			}
			if (specialChar.equals("y")) {
				chars += "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";
			}

			if (!includeString.equals("")) {
				if (position.equals("b")) {
					password = includeString + password;
					length -= includeString.length();
				} else if (position.equals("m")) {
					int index = random.nextInt(length - includeString.length());
					String tempPassword = password;
					password = "";
					for (int i = 0; i < tempPassword.length() && i < index; i++) {
						password = password + tempPassword.charAt(i);
					}
					password = password + includeString;
					for (int i = index; i < tempPassword.length(); i++) {
						password = password + tempPassword.charAt(i);
					}
					length -= includeString.length();
				} else if (position.equals("e")) {
					password = password + includeString;
					length -= includeString.length();
				}
			}

			for (int i = 0; i < length; i++) {
				password += chars.charAt(random.nextInt(chars.length()));
			}
			System.out.println("Password: " + password);
			System.out.println(" ");
			System.out.print("Do you want to generate another password? (y/n) ");
			String answer = input.nextLine();
			while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Do you want to generate another password? (y/n) ");
				answer = input.nextLine();
			}
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("String Manipulator closed.");
				break;
			}
		}

	}

}
