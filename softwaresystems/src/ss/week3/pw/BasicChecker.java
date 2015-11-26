package ss.week3.pw;

public class BasicChecker implements Checker {
	
	private static final String INITPASS = "password";
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ") || suggestion.length() < 6);
	}
	
	public String generatePassword() {
		return INITPASS;
	}
	
}
