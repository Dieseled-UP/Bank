package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Account;

public class AccountMenu {

	public void showAccountMenu(Account account) {
		
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		int choice;
		
		try {
			do {

				System.out.println("///**** Account Main Menu ****///");
				System.out.println("1. View Balance");
				System.out.println("2. Make Withdraw");
				System.out.println("3. Make Deposit");
				System.out.println("4. Save Accounts");
				System.out.println("5. Read Account Details");
				System.out.println("Enter 0 to exit");
				choice = keyIn.nextInt();

				switch (choice) {
				case 1:
					System.out.printf("Balance: %f\n", account.getBalance());
					break;
				case 2:
					WithDrawMenu.showWithdrawMenu(account);
					break;
				case 3:
					DepositMenu.showDepositMenu(account);
					break;
				case 4:
					account.saveAccountDetails(account);
					break;
				case 5:
					account.readAccountDetails();
					break;
				default:
					if(choice == 0) {
						System.out.println("Goodbye");
						//System.exit(0);
					} else {
						System.out.println("Invlaid choice");
					}
				}
			} while (choice != 0);

		} catch (InputMismatchException ex) {

			ex.printStackTrace();
			showAccountMenu(account);
		}
	}
}










