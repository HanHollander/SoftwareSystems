package ss.week2;

import ss.week2.LampEnum.State;

public class LampTest {
	
	private LampEnum lamp;
	
	//Constructor for LampTest
	public LampTest() {
		lamp = new LampEnum(State.OFF);
	}
	
	//Run the tests
	public void runTest() {
		testInitialSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
		testSwitchSetting();
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
}
