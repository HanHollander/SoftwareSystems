package ss.week4.math;

public class Constant implements Function, Integrandable {

	private double constant;
	
	public Constant(double c) {
		this.constant = c;
	}
	
	public double apply(double x) {
		return constant;
	}

	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return "" + constant;
	}
	
	public Function integrand() {
		return new LinearProduct(this, new Exponent(1));
	}

}
