package ss.week3;

public class Format {
	
	public static void printLine(String text, double amount) {
		System.out.printf("%-15s %10.2f %n", text, amount);
	}
	
	public static void main(String[] args) {
		printLine("Weidse", -30.00);
		printLine("Solo", 999.00);
	}

}
