package ss.week2.hotel;

public class Safe {
	//@ invariant !isActive() ==> !isOpen();
	
	private enum Activation {
		ACTIVE, INACTIVE
	}
	private enum State {
		OPEN, CLOSED
	}
	
	private /*@ spec_public */ Password pass;
	private Activation activation;
	private State state;
	
	public Safe() {
		activation = Activation.INACTIVE;
		state = State.CLOSED;
		pass = new Password();
	}
	
	public static void main(String[] args) {
		Safe safe = new Safe();
		safe.activate(null);
	}
	
	//@ requires password != null;
	//@ ensures \result ==> isActive();
	//@ ensures (pass.testWord(password) && \old(!isActive())) ==> isActive();
	public boolean activate(String password) {
		//assert password != null;
		boolean result = false;
		if(pass.testWord(password) && activation == Activation.INACTIVE) {
			activation = Activation.ACTIVE;
			result = true;
		} return result;
	}
	
	//@ ensures isActive() == false;
	public boolean deactivate() {
		boolean result = false;
		if(activation == Activation.ACTIVE) {
			activation = Activation.INACTIVE;
			state = State.CLOSED;
			result = true;
		} return result;
	}
	
	//@ requires password != null;
	//@ ensures isOpen() == true;
	public boolean open(String password) {
		assert password != null;
		boolean result = false;
		if(pass.testWord(password) && state == State.CLOSED && isActive()) { //and active
			state = State.OPEN;
			result = true;
		} return result;
	}
	
	//@ ensures isOpen() == false;
	public boolean close() {
		boolean result = false;
		if(state == State.OPEN) {
			state = State.CLOSED;
			result = true;
		} return result;
	}
	
	/*@ pure */ public boolean isActive() {
		return activation == Activation.ACTIVE;
	}
	
	/*@ pure */ public boolean isOpen() {
		return state == State.OPEN;
	}
	
	//@ ensures \result != null;
	/*@ pure */ public Password getPassword() {
		return pass;
	}
	

}
