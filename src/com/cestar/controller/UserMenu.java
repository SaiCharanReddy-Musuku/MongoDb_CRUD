package com.cestar.controller;

import java.util.Scanner;

/*
 * This class displays menu to the end user
 */
public class UserMenu {
	public static void main(String[] args) {
		Controller ct = new Controller();
		try (Scanner sc = new Scanner(System.in)) {
			int entry = 0;

			while (entry != 5) {
				System.out.println(
						"\nPlease use one of the options!\nEnter 1 to display all patients\nEnter 2 to insert a patient\nEnter 3 to update a patient data\nEnter 4 to delete a patient\nEnter 5 to exit");
				entry = sc.nextInt();

				switch (entry) {
				case 1: {
					ct.display();
					break;
				}
				case 2: {
					ct.insert();
					break;
				}
				case 3: {
					ct.update();
					break;
				}
				case 4: {
					ct.delete();
					break;
				}
				case 5: {
					System.out.println("Thank you for using our app!!");
					System.exit(0);
					break;
				}
				default: {
					System.out.println("Invalid entry!!\nPlease enter no's from 1 to 5 only");
				}
				}
			}
		}
	}
}
