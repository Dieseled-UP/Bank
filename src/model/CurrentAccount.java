package model;

import services.IAccountService;

/**
 * @author Denis Bourne
 */
public class CurrentAccount extends Account implements IAccountService {

	private static final long serialVersionUID = 1L;

	private double overDraft;

	/**
	 * Default constructor that calls the super class Account to set the account
	 * Number
	 */
	public CurrentAccount() {
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
	 * @param overDraft
	 *            the overdraft value of the Account
	 */
	public CurrentAccount(Name accountHolder, String address, Date dateOpened, double balance, int pin,
			double overDraft) {
		super(accountHolder, address, dateOpened, balance, pin);
		this.overDraft = overDraft;
	}

	/**
	 * @return the overDraft
	 */
	public double getOverDraft() {
		return overDraft;
	}

	/**
	 * @param overDraft
	 *            the overDraft to set
	 */
	public void setOverDraft(double overDraft) {
		this.overDraft = overDraft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nOver Draft: " + overDraft;
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

	}

	@Override
	public double withdraw(double amount) {

		return 0;
	}

}
