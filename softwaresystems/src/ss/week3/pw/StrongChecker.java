package ss.week3.pw;

public class StrongChecker extends BasicChecker{
	
	public strongAcceptable(String suggestion) {
		return (super.acceptable(suggestion) && suggestion.charAt(0) == 1);
	}

}
