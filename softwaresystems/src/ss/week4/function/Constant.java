package ss.week4.function;

public class Constant implements Function {

	private double constant;
	
	public Constant(double c) {
		this.constant = c;
	}
	
	public double apply() {
		return constant;
	}

	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return "f(x) = " + constant;
	}

}
