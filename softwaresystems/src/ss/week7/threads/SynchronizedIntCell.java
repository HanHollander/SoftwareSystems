package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value;
	private boolean valueSet = false;
	
	@Override
	public synchronized void setValue(int val) {
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}
		value = val;
		valueSet = true;
		notifyAll();
	}

	@Override
	public synchronized int getValue() {
		while(!valueSet) {
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("interrupted");
			}
		}
		valueSet = false;
		notifyAll();
		return value;
	}
	
	

}
