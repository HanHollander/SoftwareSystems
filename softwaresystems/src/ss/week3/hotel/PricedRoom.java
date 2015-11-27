package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {

	private double roomPrice;
	
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}

	public double getAmount() {
		return roomPrice;
	}
	
	public String toString() {
		return "Price per night: " + roomPrice;
	}
}
