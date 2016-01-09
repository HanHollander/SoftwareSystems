package ss.week7.threads;

import java.util.concurrent.locks.*;

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
//	private int value;
//	final Lock lock = new ReentrantLock();
//	final Condition newIntAvailable = lock.newCondition();
//	final Condition intIsRead = lock.newCondition();
//	private boolean newInt = false;
//	@Override
//	public void setValue(int val) {
//		lock.lock();
//		while (newInt) {
//			try {
//				intIsRead.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		value = val;
//		newIntAvailable.signal();
//		newInt = true;
//		lock.unlock();
//	}
//
//	@Override
//	public int getValue() {
//		lock.lock();
//		while (!newInt) {
//			try {
//				newIntAvailable.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		int result = value;
//		intIsRead.signal();
//		newInt = false;
//		lock.unlock();
//		return result;
//	}
	

}
