package ss.week4.math;

public class Exponent implements Function, Integrandable {

	private double exponent;
	
	public Exponent(double n) {
		exponent = n;
	}
	
	public double apply(double x) {
		return Math.pow(x, exponent);
	}

	public Function derivative() {
		return new LinearProduct(new Constant(exponent), new Exponent(exponent - 1));
	}
	
	public Function integrand() {
		return new LinearProduct(new Constant(Math.pow((exponent + 1), -1)), new Exponent(exponent + 1));
	}
	
	public String toString() {
		return "x^" + exponent;
	}

}
