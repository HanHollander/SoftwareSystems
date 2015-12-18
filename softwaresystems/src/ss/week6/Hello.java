package ss.week6;

import java.util.Scanner;

public class Hello {
	
	public Hello() {
	}
	
	public static void main(String[] args) {
		String q = "And what be yer name lad?";
		String name;
		do {
			System.out.println(q);
			name = readString();
			if (name.length() != 0) {
				String answer = "Hello " + name + ". ";
				System.out.println(answer);
			}
		} while (name.length() != 0);
	}
	
	public static String readString() {
		Scanner scanner = new Scanner(System.in);
		String result = "";
		
			if (scanner.hasNextLine()) {
				result = scanner.nextLine();
			}
		
		return result;
	}

}
