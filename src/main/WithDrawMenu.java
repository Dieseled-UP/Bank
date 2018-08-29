package main;

import java.util.Scanner;

import model.Account;
import model.CurrentAccount;
import model.JointAccount;

public class WithDrawMenu {

	public static void showWithdrawMenu(Account account) {
		
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		double amount;

		try {

			System.out.println("//** Withdraw Menu **//");

			System.out.println("Please amount amount you wish to withdraw: ");
			amount = keyIn.nextDouble();

			if (account instanceof CurrentAccount) {

				CurrentAccount currAcc = (CurrentAccount) account;
				currAcc.withdraw(amount);
			} else if (account instanceof JointAccount) {

				JointAccount jointAcc = (JointAccount) account;
				jointAcc.withdraw(amount);
			}

		} catch (Exception ex) {

		}
	}
}
