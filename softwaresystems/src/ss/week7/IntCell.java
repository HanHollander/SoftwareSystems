package ss.week7;

public class IntCell {
    private int contents = 0;

    public void add(int amount) {
        contents = contents + amount;
    }
    public int get() {
        return contents;
    }

    public static void main(String[] args) {
        IntCell cell = new IntCell();
        Adder a1 = new Adder(cell, 1);
        Adder a2 = new Adder(cell, 2);
        a1.start();
        a2.start();
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cell.get());
    }
}

class Adder extends Thread {
    private IntCell cell;
    private int amount;
    boolean alreadyAdded = false;
    String firstName = "Thread-0";

    public Adder(IntCell cellArg, int amountArg) {
        this.cell = cellArg;
        this.amount = amountArg;
    }
    public synchronized void run() {
//    	while (!alreadyAdded && !(getName().equals(firstName))) {
//    		try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//			}
//    	}
//    	System.out.println(getName());
//        cell.add(amount);
//        alreadyAdded = true;
//        notifyAll();
    	synchronized(IntCell.class) {
	    	System.out.println(getName() + " did his buisness");
	        cell.add(amount);
	        alreadyAdded = true;
	        System.out.println(getName() + " notified");
    	}
    }
}
