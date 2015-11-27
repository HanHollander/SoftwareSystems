package ss.week3.hotel;

public class TestItem implements Bill.Item {

	private String name;
	private double price;
	
	public TestItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return name + ":";
	}

}
