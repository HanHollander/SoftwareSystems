package ss.week3.pw;

public class Password {
	
	//public static final String INITIAL = "password";
	
	private String password;
	private Checker checker;
	//private String factoryPassword;
	
	public Password(Checker checker) {
		this.checker = checker;
		password = checker.generatePassword();
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	public boolean acceptable(String suggestion) {
		return !(suggestion.contains(" ")|| suggestion.length() < 6);
	}
	
	public boolean setWord(String oldPass, String newPass) {
		boolean result = false;
		if (testWord(oldPass) && checker.acceptable(newPass)) {
			password = newPass;
			result = true;
		}
		return result;
	}
	
	public boolean testWord(String test) {
		return (test.equals(password));
	}
	
	public Checker getChecker() {
		return checker;
	}
	
	//public String getFactoryPassword() {
		//return factoryPassword;
	//}

}
