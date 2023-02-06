package org.lessons.java.program;

import java.util.Scanner;

public class TestToFixLoopIssue {
	public void check() {
		Scanner scan = new Scanner(System.in);
		boolean repeat = true;
		while (repeat) {
			System.out.print("Insert a number: ");
			if (scan.hasNextInt()) {
				int number = scan.nextInt();
				System.out.println(" ");
				System.out.println("You inserted " + number);

				System.out.println("Do you want to check another number?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				if (scan.nextInt() == 2) {
					repeat = false;
				}
			} else {
				System.out.println("Invalid input. Try again.");
				scan.nextLine();
			}
		}

	}
}
