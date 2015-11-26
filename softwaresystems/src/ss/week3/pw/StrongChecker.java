package ss.week3.pw;

public class StrongChecker extends BasicChecker{
	
	public static final String INITPASS = "password123";
	
	public boolean acceptable(String suggestion) {
		return super.acceptable(suggestion) && firstCharIsLetter(suggestion) && lastCharIsNumber(suggestion);
	}
	
	public boolean firstCharIsLetter(String suggestion) {
		int c = (int)suggestion.charAt(0);
		return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
	}
	
	public boolean lastCharIsNumber(String suggestion) {
		int c = (int)suggestion.charAt(suggestion.length() - 1);
		return (c >= 48 && c <= 57);
	}
	
	public String generatePassword() {
		return INITPASS;
	}
}
