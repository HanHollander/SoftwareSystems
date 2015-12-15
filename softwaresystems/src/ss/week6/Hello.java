package ss.week6;

import java.util.Scanner;

public class Hello {
	
	public Hello() {
	}
	
	public static void main(String[] args) {
		String q = "And what be yer name lad?";
		while (true) {
			System.out.println(q);
			String answer = "Hello " + readString() + ". ";
			System.out.println(answer);
			q = answer + q;
		}
	}
	
	public static String readString() {
		Scanner scanner = new Scanner(System.in);
		String result = "";
		
		while (result == "") {
			if (scanner.hasNextLine()) {
				result = scanner.nextLine();
			}
		}
		
		return result;
	}

}
