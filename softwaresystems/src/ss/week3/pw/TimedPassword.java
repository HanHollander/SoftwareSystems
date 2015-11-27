package ss.week3.pw;

public class TimedPassword extends Password {
	
	private long validTime;
	private static final long INITVALIDTIME = 100000;
	private long initTime;
	
	public TimedPassword(long validTime) {
		this.validTime = validTime;
		initTime = java.lang.System.currentTimeMillis();
	}
	
	public TimedPassword() {
		this(INITVALIDTIME);
		initTime = java.lang.System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		return java.lang.System.currentTimeMillis() > initTime + validTime;
	}
	
	public boolean setWord(String oldPass, String newPass) {
		boolean result = false;
		if (super.setWord(oldPass, newPass)) {
			result = true;
			initTime = java.lang.System.currentTimeMillis();
		}
		return result;
	}

}
