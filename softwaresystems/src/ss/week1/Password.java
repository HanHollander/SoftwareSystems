package ss.week1;

public class Password {
	
	public static final String INITIAL = "initialpassword";
	
	private String password;
	
	public Password() {
		this.password = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ")|| suggestion.length() < 6);
	}
	
	public boolean setWord(String oldPass, String newPass) {
		boolean result = false;
		if (testWord(oldPass) && acceptable(newPass)) {
			password = newPass;
			result = true;
		}
		return result;
	}
	
	public boolean testWord(String test) {
		return (test.equals(password));
	}

}
