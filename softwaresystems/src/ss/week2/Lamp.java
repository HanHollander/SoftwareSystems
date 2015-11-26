package ss.week2;

public class Lamp {
	
	//@ invariant getSetting() >= 0 && getSetting() < 4;
	
	//Attribute for Lamp
	private int setting = 0;
	
	//Constructor for Lamp
	public Lamp(){
	}
	
	//Main method
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		System.out.println(lamp.getSetting());
	}
	
	//Get the setting of Lamp
	
	/*@ pure */ public int getSetting() {
		assert setting >= 0 && setting < 4;
		return setting;
	}
	
	//Switch the setting
	//@ ensures getSetting() == (\old(getSetting()) + 1) % 4;
	public void switchSetting() {
		assert setting >= 0 && setting < 4;
		setting++;
		setting = setting % 4;
	}
}
