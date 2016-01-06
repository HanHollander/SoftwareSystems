package ss.week7.threads;

import java.util.concurrent.locks.*;

public class TestSyncConsole extends Thread {
	
	Lock l = new ReentrantLock(true);
	
	public TestSyncConsole(String name) {
		super(name);
	}
	
	private void sum() {
		System.out.println(l.toString());
		
		l.lock();
	
		System.out.println(l.toString());
		int i;
		int j;
		i = SyncConsole.readInt(getName() + ": first term? ");
		j = SyncConsole.readInt(getName() + ": second term? ");
		SyncConsole.println(getName() + ": " + i + " + " + j + " = " + (i + j));
	
		l.unlock();
		
		
	}
	
	public void run() {
		sum();
	}
	
	public static void main(String[] args) {
		new TestSyncConsole("A").start();
		new TestSyncConsole("B").start();
	}

}
