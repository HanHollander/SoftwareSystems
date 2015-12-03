package ss.week4.math;

public class Polynomial implements Function, Integrandable {

	private LinearProduct[] linearProducts;
	private double[] parts;
	
	public Polynomial(double[] parts) {
		int partsLength = parts.length;
		this.parts = parts;
		linearProducts = new LinearProduct[partsLength];
		for (int i = 0; i < partsLength; i++) {
			linearProducts[i] = new LinearProduct(new Constant(parts[i]), new Exponent(i));
		}
	}
	
	public double apply(double x) {
		double result = 0;
		for (int i = 0; i < linearProducts.length; i++) {
			result = result + linearProducts[i].apply(x);
		}
		return result;
	}

	public Function derivative() {
		Function result = null;
		for (int i = 0; i < linearProducts.length; i++) {
			if (i == 0) {
				result = new Constant(0);
			} else {
				result = new Sum(result, linearProducts[i].derivative());
			}
		}
		return result;
	}
	
	public Function integrand() {
		Function result = null;
		for (int i = 0; i < linearProducts.length; i++) {
			if (i == 0) {
				result = new LinearProduct(new Constant(parts[0]), new Exponent(1));
			} else {
				result = new Sum(result, linearProducts[i].integrand());
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < linearProducts.length; i++) {
			result = result + " + " + linearProducts[i].toString();
		}
		result.replaceFirst(" + ", "");
		return result;
	}

}
