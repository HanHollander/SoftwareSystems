package ss.week7.account;

public class MyThread extends Thread {
	
	private double theAmount;
	private int theFrequency;
	private Account theAccount;
	
	public MyThread (double amount, int frequency, Account account) {
		theAmount = amount;
		theFrequency = frequency;
		theAccount = account;
		executeTransaction();
	}
	
	public void executeTransaction() {
		for (int i = 0; i < theFrequency; i++) {
			theAccount.transaction(theAmount);
		}
	}

}
