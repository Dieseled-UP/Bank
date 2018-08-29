package tests;

import model.Account;
import model.CurrentAccount;
import model.Date;
import model.Name;

public class CurrentAccountTester {

	public static void main(String[] args) {

		CurrentAccount caOne = new CurrentAccount();

		CurrentAccount caTwo = new CurrentAccount(new Name("Ms", "Susan", "Doherty"),
				"Main Street",
				new Date(2, 6, 1998), 870.50, 5678, 0.0);

		Name name = new Name("Mr", "Paddy", "Woods");
		Date date = new Date(22, 10, 2005);

		caOne.setAccountHolder(name);
		caOne.setAddress("Upper Street");
		caOne.setDateOpened(date);
		caOne.setBalance(2005.00);
		caOne.setOverDraft(500);

		System.out.println(caOne + "\n");
		System.out.println(caTwo.getAccountHolder());
		System.out.println(caTwo.getAccountNumber());
		System.out.println(caTwo.getOverDraft());

		/*
		 * This is example of Polymorphism we declare an Account object but we then
		 * instantiate it using the CurrentAccount. With this we can call all methods
		 * associated with the Account class but we still can't call any methods that is
		 * associated with the CurrentAccount so we cannot call to getOverDraft or
		 * setOverDraft will fail.
		 * 
		 * Polymorphism allows objects from the super class take on the type of the
		 * subclass.
		 */
		Account accOne = new CurrentAccount(new Name("Mr", "Phil", "Coulsen"), "Hill Top",
				new Date(14, 5, 2002), 340, 9876,
				200);

		System.out.println("\n" + accOne.getBalance());

		// We can print all details of the Account though including the
		// overdraft variable
		System.out.println("\n" + accOne);
	}

}






















