package ss.week7;


public class QuickSort implements Runnable {
//	
//	private int[] a;
//
// 	public QuickSort(int[] a) {
// 		this.a = a;
// 	}
//	
//	public void run() {
//		qsort(a, 0, a.length - 1);
//	}
//	
//    public static void qsort(int[] a) {
//    	(new Thread(new QuickSort(a))).start();
//    }
//    public static void qsort(int[] a, int first, int last){
//        if (first < last) {
//            int position = partition(a, first, last);
//            qsort(a, first, position - 1);
//            qsort(a, position + 1, last);
//            //(new Thread(new QuickSort(a, first, position - 1))).start();
//            //(new Thread(new QuickSort(a, position + 1, last))).start();
//        }
//    }
//    public static int partition(int[] a, int first, int last) {
//
//        int mid = (first + last) / 2;
//        int pivot = a[mid];
//        swap(a, mid, last); // put pivot at the end of the array
//        int pi = first;
//        int i = first;
//        while (i != last) {
//            if (a[i] < pivot) {
//                swap(a, pi, i);
//                pi++;
//            }
//            i++;
//        }
//        swap(a, pi, last); // put pivot in its place "in the middle"
//        return pi;
//    }
//    public static void swap(int[] a, int i, int j) {
//        int tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }
/////////////////////////////////////////First version above\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public static int[] a;
	private int first;
	private int seccond;

 	public QuickSort(int[] b) {
 		a = b;
 		first = 0;
 		seccond = a.length - 1;
 	}
 	
 	public QuickSort(int first, int seccond) {
 		this.first = first;
 		this.seccond = seccond;
 	}
	
	public void run() {
		qsort(first, seccond);
	}
	
    public static void qsort(int[] c) {
    	Thread thread = new Thread(new QuickSort(c));
    	thread.start();
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void qsort(int first, int last){
        if (first < last) {
            int position = partition(first, last);
            //qsort(a, first, position - 1);
            //qsort(a, position + 1, last);
            Thread thread1 = new Thread(new QuickSort(first, position - 1));
            Thread thread2 = new Thread(new QuickSort(position + 1, last));
            thread1.start();
            thread2.start();
            try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
    public static int partition(int first, int last) {
		int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(pi, i);
                pi++;
            }
            i++;
        }
        swap(pi, last); // put pivot in its place "in the middle"
        return pi;
    }

    public static void swap(int i, int j) {
    	int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
