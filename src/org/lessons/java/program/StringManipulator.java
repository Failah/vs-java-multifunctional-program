package org.lessons.java.program;

import java.text.Normalizer;
import java.util.Scanner;

public class StringManipulator {
	public static void main(String[] args) {
		Scanner scSM = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.print("Enter a string: ");
			String str = scSM.nextLine();

			if (str == null || str.isEmpty()) {
				System.out.println("The string cannot be empty. Enter a new string.");
				continue;
			}

			System.out.println("Reversed string: " + reverseString(str));
			System.out.println("String without vowels: " + removeVowels(str));
			System.out.println("String without consonants: " + removeConsonants(str));
			System.out.println("Number of words in the string: " + countWords(str));
			System.out.println("Number of characters in the string (counting spaces): " + countCharacters(str));
			System.out.println("Number of characters in the string (without spaces): " + countCharactersNoSpaces(str));
			System.out.println("String without any space: " + removeSpaces(str));
			System.out.println(isPalindrome(str));

			System.out.print("Do you want to enter another string? (y/n) ");
			String answer = scSM.nextLine();
			while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
				System.out.print("Invalid input. Please enter 'y' or 'n'. ");
				System.out.print("Do you want to enter another string? (y/n) ");
				answer = scSM.nextLine();
			}
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("String Manipulator closed.");
				repeat = false;
			}
		}
	}

	private static String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	private static String removeVowels(String str) {
		return str.replaceAll("[aeiouAEIOU]", "");
	}

	private static String removeConsonants(String str) {
		return str.replaceAll("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", "");
	}

	public static int countWords(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}

	public static int countCharacters(String str) {
		if (str == null) {
			return 0;
		}
		return str.length();
	}

	public static int countCharactersNoSpaces(String str) {
		if (str == null) {
			return 0;
		}
		return removeSpaces(str).length();
	}

	public static String removeSpaces(String str) {
		if (str == null) {
			return null;
		}

		return str.replaceAll("\\s", "");
	}

	public static String isPalindrome(String str) {
		String strpal = removeSpaces(str);
		String palindromeMessageString = "";
		if (str == null) {
			return "The string is null";
		}
		strpal = Normalizer.normalize(strpal, Normalizer.Form.NFD);
		strpal = strpal.replaceAll("[^\\p{ASCII}]", "");
		int length = strpal.length();
		for (int i = 0; i < length / 2; i++) {
			if (strpal.charAt(i) != strpal.charAt(length - i - 1)) {
				palindromeMessageString = "The string is not palindrome";
				return palindromeMessageString;
			}
		}
		palindromeMessageString = "The string is palindrome";
		return palindromeMessageString;
	}

}
