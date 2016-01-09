package ss.week7.account;

public class MyThread extends Thread { // implements Runnable {
	
	private double theAmount;
	private int theFrequency;
	private Account theAccount;
	
	public MyThread (double amount, int frequency, Account account) {
		theAmount = amount;
		theFrequency = frequency;
		theAccount = account;
	}
	
	public void run() {
		for (int i = 0; i < theFrequency; i++) {
			theAccount.transaction(theAmount);
			System.out.println(theAmount + ", " + theAccount.getBalance());
		}
	}

}
