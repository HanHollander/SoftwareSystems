package ss.week1;

public class DollarsAndCentsCounter {
	
	private int dollars;
	private int cents;
	
	public DollarsAndCentsCounter() {
		this.dollars = 0;
		this.cents = 0;
	}
	
	public int dollars() {
		return dollars;
	}
	
	public int cents() {
		return cents;
	}
	
	public void add(int dollars, int cents) {
		this.dollars = this.dollars + dollars;
		this.cents = this.cents + cents;
		if (this.cents >= 100) {
			int centdollars = this.cents / 100;
			this.cents = this.cents - (centdollars * 100);
			this.dollars = this.dollars + centdollars;
		}
		
	}
	
	public void reset() {
		dollars = 0;
		cents = 0;
	}
}
