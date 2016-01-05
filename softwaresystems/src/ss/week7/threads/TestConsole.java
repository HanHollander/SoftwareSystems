package ss.week7.threads;

public class TestConsole extends Thread {
	
	public TestConsole(String name) {
		super(name);
	}
	
	private void sum() {
		int i;
		int j;
		i = Console.readInt(getName() + ": first term? ");
		j = Console.readInt(getName() + ": second term? ");
		Console.println(getName() + ": " + i + " + " + j + " = " + (i + j));
	}
	
	public void run() {
		sum();
	}
	
	public static void main(String[] args) {
		new TestConsole("A").start();
		new TestConsole("B").start();
	}

}
