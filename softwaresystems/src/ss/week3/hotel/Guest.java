package ss.week3.hotel;

/**
 * Guest with name and possible rented room
 * @author Weidse en Solo
 * @version 4.20
 */

public class Guest {
	
	//Instance variables
	private String name;
	private Room room;
	
	//Constructor
	/**
     * Creates a <code>Guest</code> with the given name, without a room.
     * @param name name of the new <code>Guest</code>
     */
	public Guest(String name) {
		this.name = name;
	}
	
	//Queries
	/**
     * Returns the name of this <code>Guest</code>.
     */
	/*@ pure*/ public String getName() {
		return name;
	}
	/**
     * Returns the current room of this <code>Guest</code>.
     * @return the room of this <code>Guest</code>;
     *         <code>null</code> if this <code>Guest</code> 
     *         is not currently renting a room
     */
	/*@ pure*/ public Room getRoom() {
		return room;
	}
	
	//Commands
	/**
	 * Return if <code>Guest</code> has no room yet and checks in
	 * @param room
	 * @return <code>true</code> if the <code>Guest</code>
	 * has no room yet, otherwise <code>false</code>
	 */
	public boolean checkin(Room room) {
		if (room.getGuest() == null) {
			room.setGuest(this);
			this.room = room;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Return if <code>Guest</code> has no room yet and checks out
	 * @return <code>false</code> if the <code>Guest</code>
	 * has no room yet, otherwise <code>true</code>
	 */
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}
	}
	
	//Description of guest
	public String toString() {
		return "Guest: " + name + " and room: " + room.getNumber();
	}
}
