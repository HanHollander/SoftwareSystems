package ss.week1;

public class Lamp {
	
	//Attribute for Lamp
	private int setting;
	
	//Constructor for Lamp
	public Lamp(int setting){
		this.setting = setting;
	}
	
	//Main method
	public static void main(String[] args) {
	}
	
	//Get the setting of Lamp
	public String getSetting() {
		if (setting == 0){
			return "off";
		} else if (setting == 1) {
			return "low";
		} else if (setting == 2) {
			return "medium";
		} else if (setting == 3) {
			return "high";
		} else {
			return "";
		}
	}
	
	//Switch the setting
	public void switchSetting() {
		setting++;
		setting = setting % 4;
	}
	
	//Return if setting is high
	public boolean passed() {
		return(setting == 3);
	}
}
