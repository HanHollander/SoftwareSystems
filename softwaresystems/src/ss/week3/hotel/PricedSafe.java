package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {

	private String name;
	private double price;
	
	public PricedSafe(double price) {
		name = "Safe";
		this.price = price;
	}
	
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return "Safe: " + price;
	}

}
