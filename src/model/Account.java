package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int nextAccountNumber = 10010;
	private int accountNumber;
	private Name accountHolder;
	private String address;
	private Date dateOpened;
	private double balance;
	private String fileBin = "account_details.bin";
	private String fileText = "account_details.txt";

	private int pin;
	private static ArrayList<Account> accounts = new ArrayList<>();

	/**
	 * Default constructor will generate an uninitialized Account object with the
	 * accountNumber set
	 */
	public Account() {
		this.accountNumber = nextAccountNumber++;
	}

	/**
	 * User defined constructor with parameters
	 * 
	 * @param accountHolder
	 *            the name associated with the Account
	 * @param address
	 *            a String value representing the address
	 * @param dateOpened
	 *            the date the Account was opened
	 * @param balance
	 *            the balance of the Account
	 * @param pin
	 *            the pin number of the Account
	 */
	public Account(Name accountHolder, String address, Date dateOpened, double balance, int pin) {
		this.accountNumber = nextAccountNumber++;
		this.accountHolder = accountHolder;
		this.address = address;
		this.dateOpened = dateOpened;
		this.balance = balance;
		this.pin = pin;
	}

	/**
	 * Method to return the name of the Account Holder
	 * 
	 * @return the accountHolder
	 */
	public Name getAccountHolder() {
		return accountHolder;
	}

	/**
	 * Method to set the name Of the Account Holder
	 * 
	 * @param accountHolder
	 *            the name of the account holder to be set
	 */
	public void setAccountHolder(Name accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
	 * Method to return the address associated with the Account
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method to set the address for the Account
	 * 
	 * @param address
	 *            the address to be set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method to get the date the Account was opened
	 * 
	 * @return the dateOpened
	 */
	public Date getDateOpened() {
		return dateOpened;
	}

	/**
	 * Method to set the date the Account was opened
	 * 
	 * @param dateOpened
	 *            the open date to be set
	 */
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	/**
	 * Method to return the balance for the Account
	 * 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Method to set the balance for the Account
	 * 
	 * @param balance
	 *            the balance to be set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Method to return the account number for the Account
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Method to return the pin number for the Account
	 * 
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * Method to set the Pin number for the Account
	 * 
	 * @param pin
	 *            the pin to be set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

	public void saveAccountDetails(Account account) {

		try (ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(fileBin))) {
			bw.writeObject(account);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// This writes data to a text file
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileText))) {
			// bw.write(account.toString());
			// bw.newLine();

			for (Account tempAccount : accounts) {
				bw.write(tempAccount.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to read from a binary file and display the details to the console.
	 */
	public void readAccountDetails() {

		// Read from the chosen file
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileBin))) {

			// Print to the console the details of the file
			System.out.println(ois.readObject());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to save a new Account to an ArrayList of Accounts
	 * 
	 * @param account
	 *            the Account to be saved
	 */
	public static void saveAccount(Account account) {
		accounts.add(account);
	}

	/**
	 * Method to return the ArrayList of Accounts this is a polymorphic ArrayList
	 * and will contain subclasses of the Account class such as CurrentAccounts and
	 * JointAccounts
	 * 
	 * @return the accounts
	 */
	public static ArrayList<Account> getAccounts() {

		CurrentAccount currAccOne = new CurrentAccount(new Name("Ms", "Susan", "Doherty"), "Main Street",
				new Date(2, 6, 1998), 870.50, 1234, 300);

		CurrentAccount currAccTwo = new CurrentAccount(new Name("Mr", "Tony", "Stark"), "Avengers Tower",
				new Date(2, 6, 1975), 10000000000.00, 9876, 5000);

		JointAccount jointAccOne = new JointAccount(new Name("Ms", "Susan", "Doherty"), "Main Street",
				new Date(2, 6, 1998), 10000.50, 4321, new Name("Mr", "Pat", "Doherty"));

		accounts.add(currAccOne);
		accounts.add(currAccTwo);
		accounts.add(jointAccOne);

		return accounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + accountNumber + ", accountHolder=" + accountHolder + ", address=" + address
				+ ", dateOpened=" + dateOpened + ", balance=" + balance + "]";
	}

}
