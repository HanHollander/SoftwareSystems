package ss.week3.hotel;

import ss.week3.Format;

public class Bill {
	
	public static interface Item {
		public double getAmount();
		public String toString();
	}
	
	private java.io.PrintStream theOutStream;
	private double sum;
	
	public Bill(java.io.PrintStream theOutStream) {
		this.theOutStream = theOutStream;
	}
	
	public void newItem(Bill.Item item) {
		theOutStream.print(Format.printLine(item.toString(), item.getAmount()));
		sum += item.getAmount();
	}
	
	public void close() {
		theOutStream.print(Format.printLine("sum:", getSum()));
		theOutStream.flush();
	}
	
	public double getSum() {
		return sum;
	}
	
	public static void main(String[] args) {
		Bill bill = new Bill(new java.io.PrintStream(System.out, false));
		bill.theOutStream.print(Format.printLine("test", 3));
		bill.theOutStream.print(Format.printLine("test", 2));
		bill.theOutStream.flush();
		bill.theOutStream.print(Format.printLine("test", 644));
	}

}
