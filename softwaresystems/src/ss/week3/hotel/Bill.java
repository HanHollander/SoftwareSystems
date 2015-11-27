package ss.week3.hotel;

import ss.week3.Format;
import java.io.PrintStream;

public class Bill {
	
	public static interface Item {
		public double getAmount();
		public String toString();
	}
	
	private PrintStream theOutStream;
	private double sum;
	
	public Bill(PrintStream theOutStream) {
		this.theOutStream = theOutStream;
	}
	
	public void newItem(Bill.Item item) {
		if (theOutStream != null) {
			theOutStream.print(Format.printLine(item.toString(), item.getAmount()));
		}
		sum += item.getAmount();
	}
	
	public void close() {
		theOutStream.print(Format.printLine("sum:", getSum()));
	}
	
	public double getSum() {
		return sum;
	}

}
