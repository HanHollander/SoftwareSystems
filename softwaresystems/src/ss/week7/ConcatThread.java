package ss.week7;

public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;
    private String second = "two;";

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public synchronized void run() {
//7.21.3    	synchronized(text) {
//    		text = text.concat(toe);
//    	}
    	
    	
    	if (text.equals("") && toe.equals(second)) {
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
    	text = text.concat(toe);
    	notifyAll();
    	
    	
    }

    public static void main(String[] args) {
        //(new ConcatThread("one;")).start();
        //(new ConcatThread("two;")).start();
        ConcatThread ct1 = (new ConcatThread("one;"));
        ConcatThread ct2 = (new ConcatThread("two;"));
        ct1.start();
        ct2.start();
        try {
            ct1.join();
            ct2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(text);
        
    }
}
