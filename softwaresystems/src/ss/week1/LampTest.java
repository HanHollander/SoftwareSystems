package ss.week1;

public class LampTest {
	
	private Lamp lamp;
	
	//Constructor for LampTest
	public LampTest() {
		lamp = new Lamp(0);
	}
	
	//Run the tests
	public void runTest() {
		testInitialSetting();
		testPassed();
		testSwitchSetting();
		testPassed();
		testSwitchSetting();
		testPassed();
		testSwitchSetting();
		testPassed();
		testSwitchSetting();
	}
	
	//Test initial setting
	public void testInitialSetting() {
		lamp.getSetting();
		System.out.println("Initial setting: " + lamp.getSetting());
	}
	
	//Test switching the setting
	public void testSwitchSetting() {
		lamp.switchSetting();
		System.out.println("New setting: " + lamp.getSetting());
	}
	
	//Test if setting is high
	public void testPassed() {
		lamp.passed();
		System.out.println(lamp.passed());
	}
}
