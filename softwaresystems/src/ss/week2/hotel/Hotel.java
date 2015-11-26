package ss.week2.hotel;

public class Hotel {
	
	private /*@ spec_public*/ Password pass;
	private String name;
	private Room room1;
	private Room room2;
	
	public Hotel(String name) {
		pass = new Password();
		this.name = name;
		room1 = new Room(1);
		room2 = new Room(2);
	}
	
	//@ requires password != "" && name != "";
	//@ ensures \result == null || \result == getRoom(name);
	//@ ensures getRoom(name).getSafe().isActive();
	public Room checkIn(String password, String name) {
		assert password!= "" && name != "";
		Room result = null;
		if (pass.testWord(password)) {
			Room freeRoom = getFreeRoom();
			if (freeRoom != null) {
				if (getRoom(name) == null) {
					Guest newGuest = new Guest(name);
					newGuest.checkin(freeRoom);
				}
				result = freeRoom;
				freeRoom.getSafe().activate(password);
			}
		}
		return result;
	}
	
	//@ requires name != "";
	//@ ensures getRoom(name) == null;
	//@ ensures !getRoom(name).getSafe().isActive();
	public void checkOut(String name) {
		assert name != "";
		//check out guest and deactivate safe if guest with name exists
		if (getRoom(name) != null) {
			getRoom(name).getSafe().deactivate();
			getRoom(name).getGuest().checkout();
		}
	}
	
	//@ ensures \result.getGuest() == null || \result == null;
	/*@ pure*/public Room getFreeRoom() {
		Room result = null;
		if (room1.getGuest() == null) {
			result = room1;
		} else if (room2.getGuest() == null) {
			result = room2;
		}
		return result;
	}
	
	//@ requires name != "";
	//@ ensures name == \result.getGuest().getName() || \result == null;
	/*@ pure*/ public Room getRoom(String name) {
		assert name != "";
		Room result = null;
		if (room1.getGuest() != null && name == room1.getGuest().getName()) {
			result = room1;
		} else if (room2.getGuest() != null && name == room2.getGuest().getName()) {
			result = room2;
		}
		return result;
	}
	
	//@ ensures getPassword().equals(pass);
	/*@ pure*/ public Password getPassword() {
		//return password of hotel
		return pass;
	}
	
	/*@ pure*/ public String toString() {
		String result1;
		String result2;
		if (room1.getGuest() != null) {
			result1 = "room 1: " + room1.getGuest();
		} else {
			result1 = "no guest in room 1";
		}
		if (room2.getGuest() != null) {
			result2 = "room 2: " + room2.getGuest();
		} else {
			result2 = "no guest in room 2";
		}
		
		String result = result1 + result2;
		return result;
	}
}
