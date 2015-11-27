package ss.week3;

public class Format {
	
	public static String printLine(String text, double amount) {
		return String.format("%-15s %10.2f %n", text, amount);
	}
	
	public static void main(String[] args) {
		System.out.print(printLine("Weidse", -30.00));
		System.out.print(printLine("Weidse", -30.00));
		printLine("Solo", 999.00);
	}

}
