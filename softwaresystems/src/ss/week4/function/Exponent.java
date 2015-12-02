package ss.week4.function;

public class Exponent implements Function {

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

}
