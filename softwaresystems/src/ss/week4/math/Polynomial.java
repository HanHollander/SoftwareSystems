package ss.week4.math;

public class Polynomial implements Function {

	//private double[] parts;
	
	public Polynomial(double[] parts) {
		int partsLength = parts.length;
		//this.parts = parts;
		LinearProduct[] linearProducts = new LinearProduct[partsLength];
		for (int i = 0; i < partsLength; i++) {
			linearProducts[i] = new LinearProduct(new Constant(parts[i]), new Exponent((double)i));
		}
	}
	
	public double apply(double x) {
		
		return 0;
	}

	public Function derivative() {
		return null;
	}

}
