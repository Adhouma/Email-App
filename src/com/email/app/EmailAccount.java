package com.email.app;

import java.util.Scanner;

public class EmailAccount {

	// Fields
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private String companySuffix = "company.com";

	// Constructor
	public EmailAccount(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("/*--- Email App ---*/");
		System.out.println("=====================\n");

		// Set department
		this.department = setDepartment();
		if (this.department == "") {
			System.out.println("Department: None\n");
		} else {
			System.out.println("Department: " + this.department + "\n");
		}

		// Set password
		this.password = generateRandomPassword();
		
		// Generate email
		this.email = generateEmail();
		System.out.println("EMAIL CREATED FOR: " + this.firstName + " " + this.lastName + "\n");
		System.out.println("Your email: " + this.email);
		System.out.println("Your password: " + this.password);
	}

	// Methods
	/**
	 * Set department for new hires
	 */
	private String setDepartment() {
		System.out.println("/*--- Select department ---*/");
		System.out.println("=============================");
		System.out.println("Please select department ['Sales', 'Development', 'Accountiong', 'None']\n");
		System.out.println("/*--- Department ---*/");
		System.out.println("======================");
		System.out.println("1- Sales.");
		System.out.println("2- Development.");
		System.out.println("3- Accounting.");
		System.out.println("4- None.\n");

		Scanner scanner = new Scanner(System.in);
		boolean validDepartment = false;
		String departmentChoice = null;
		System.out.println("Choice:");

		while (!validDepartment) {
			try {
				int departmentChoiceCode = Integer.parseInt(scanner.next());

				switch (departmentChoiceCode) {
					case 1:
						departmentChoice = "sales";
						return departmentChoice;
					case 2:
						departmentChoice = "development";
						return departmentChoice;
					case 3:
						departmentChoice = "accounting";
						return departmentChoice;
					case 4:
						departmentChoice = "";
						return departmentChoice;
					default:
						System.out.println("Please select department number between 1 and 4.");
						System.out.println("Choice:");
						System.out.print(scanner.nextLine());
				}
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid department number between 1 and 4.");
				System.out.println("Choice:");
				System.out.print(scanner.nextLine());
			}
		}

		scanner.close();
		return departmentChoice;
	}

	/**
	 * Generate random password for new hires
	 */
	private String generateRandomPassword() {
		int passwordLength = 15;
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~`!@#$%^&*()-_=+[{]}|;:\'\",<.>/?";
		char[] password = new char[passwordLength];

		for (int i = 0; i < password.length; i++) {
			int randomPossibleCharsPosition = (int) (Math.random() * possibleChars.length());
			password[i] = possibleChars.charAt(randomPossibleCharsPosition);
		}

		return new String(password);
	}
	
	/**
	 * Generate email for new hires
	 */
	private String generateEmail() {
		if (department == "") {
			return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix; 
		} else {
			return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		}
	}
}
