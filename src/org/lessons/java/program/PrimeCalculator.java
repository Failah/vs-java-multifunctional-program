package org.lessons.java.program;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("Enter the number of prime numbers to find: ");
			int n = input.nextInt();
			System.out.print("Enter from which number to start counting: ");
			long start = input.nextLong();

			ArrayList<Long> primes = findPrimes(n, start);
			printPrimes(primes);

			System.out.println(" ");
			System.out.print("Do you want to perform another prime check? (y/n) ");
			System.out.println(" ");
			String choice = input.next();
			if (!choice.equals("y")) {
				break;
			}
		}

	}

	public static ArrayList<Long> findPrimes(int n, long start) {
		ArrayList<Long> primes = new ArrayList<>();
		long num = start;
		while (primes.size() < n) {
			if (isPrime(num)) {
				primes.add(num);
			}
			num++;
		}
		return primes;
	}

	public static void printPrimes(ArrayList<Long> primes) {
		for (long prime : primes) {
			System.out.println(prime);
		}
	}

	public static boolean isPrime(long num) {
		if (num <= 1) {
			return false;
		}
		for (long i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
