package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value;
	private boolean valueRead = true;
	
	@Override
	public void setValue(int val) {
		synchronized(this) {
			while (valueRead = false) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("interrupted");
				}
				value = val;
				valueRead = false;
			}
		}
	}

	@Override
	public  int getValue() {
		valueRead = true;
		notifyAll();
		return value;
	}
	
	

}
