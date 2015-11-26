package ss.week2;

public class LampEnum {
	
	public enum State{OFF, LOW, MEDIUM, HIGH};
	
	//Attribute for Lamp
	private State setting;
	
	//Constructor for Lamp
	public LampEnum(State state){
		setting = state;
	}
	
	//Main method
	public static void main(String[] args) {
		LampEnum lamp = new LampEnum(State.LOW);
		lamp.switchSetting();
		System.out.println(lamp.getSetting());
	}
	
	//Get the setting of Lamp
	
	public State getSetting() {
		return setting;
	}
	
	//Switch the setting
	public void switchSetting() {
		if (setting == State.OFF) {
			setting = State.LOW;
		} else if (setting == State.LOW) {
			setting = State.MEDIUM;
		} else if (setting == State.MEDIUM) {
			setting = State.HIGH;
		} else if (setting == State.HIGH) {
			setting = State.OFF;
		}
	}
}
