package ss.week6;

import java.util.Scanner;

public class Words {
	
	public Words() {
	}
	
	public static void main(String[] args) {
		String q = "Would you kindly pass me a sentence, sir?";
		while (true) {
			System.out.println(q);
			readString();
			
		}
	}
	
	public static void readString() {
		Scanner scanner = new Scanner(System.in);
		String result = "";
		int counter = 1;
		while (scanner.hasNext()) {
			result = scanner.next();
			if (result.equals("end") && counter == 1) {
				break;
			}
			System.out.println("Word " + counter + ": " + result);
			counter++;
		}
	}

}
