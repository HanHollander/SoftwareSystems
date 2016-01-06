package ss.week7.account;

public class AccountSync {
	
	public static void main(String[] args) {
		Account account = new Account();
		Thread thread1 = new MyThread(-100, 11, account);
		Thread thread2 = new MyThread(9.0, 10, account);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {}
		System.out.println("final balance: " + account.getBalance());
	}

}
