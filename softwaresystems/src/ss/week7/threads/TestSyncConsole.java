package ss.week7.threads;

public class TestSyncConsole extends Thread {
	
	public TestSyncConsole(String name) {
		super(name);
	}
	
	private synchronized void sum() {
		int i;
		int j;
		i = SyncConsole.readInt(getName() + ": first term? ");
		j = SyncConsole.readInt(getName() + ": second term? ");
		Console.println(getName() + ": " + i + " + " + j + " = " + (i + j));
	}
	
	public void run() {
		sum();
	}
	
	public static void main(String[] args) {
		new TestSyncConsole("A").start();
		new TestSyncConsole("B").start();
	}

}
