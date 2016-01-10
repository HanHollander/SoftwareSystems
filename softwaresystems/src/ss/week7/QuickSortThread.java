package ss.week7;

public class QuickSortThread implements Runnable {
	
	private int[] a;
	private int first;
	private int last;

 	public QuickSortThread(int[] a, int first, int last) {
 		this.a = a;
 		this.first = first;
 		this.last = last;
 	}
	
	
	public void run() {
		QuickSort.qsort(a, first, last);
	}
	
}
