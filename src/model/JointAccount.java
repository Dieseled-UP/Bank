package model;

import services.IAccountService;

public class JointAccount extends Account implements IAccountService {

	private static final long serialVersionUID = 1L;

	private Name accountHolderTwo;

	/**
	 * Default constructor that calls the super class Account to set the account
	 * Number
	 */
	public JointAccount() {
		super();
	}

	/**
	 * User defined constructor with parameters
	 * 
	 * @param accountHolder
	 *            the name associated with the Account set in the superclass Account
	 * @param address
	 *            a String value representing the address set in the superclass
	 *            Account
	 * @param dateOpened
	 *            the date the Account was opened set in the superclass Account
	 * @param balance
	 *            the balance of the Account set in the superclass Account
	 * @param pin
	 *            the pin number of the Account set in the superclass Account
	 * @param accountHolderTwo
	 *            the name of the second account holder
	 */
	public JointAccount(Name accountHolder, String address, Date dateOpened, double balance, int pin,
			Name accountHolderTwo) {
		super(accountHolder, address, dateOpened, balance, pin);
		this.accountHolderTwo = accountHolderTwo;
	}

	/**
	 * @return the Name of second account holder
	 */
	public Name getAccountHolderTwo() {
		return accountHolderTwo;
	}

	/**
	 * @param accountHolderTwo
	 *            the Name of the second account holder to set
	 */
	public void setAccountHolderTwo(Name accountHolderTwo) {
		this.accountHolderTwo = accountHolderTwo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nAccount Holder Two:" + accountHolderTwo;
	}

	@Override
	public boolean changeName(Name name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeAddress(String address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deposit(double amount) {

		setBalance(getBalance() + amount);
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
