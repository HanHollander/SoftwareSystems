package ss.week7.account;

public class Account {
	protected double balance = 0.0;

	public synchronized void transaction(double amount) {
		while (getBalance() + amount < -1000) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted Excepterino");
			}
		}
		synchronized(this) {
			balance = balance + amount;
			notify();
		}
	}
	public synchronized double getBalance() {
		return balance;

	}
}
