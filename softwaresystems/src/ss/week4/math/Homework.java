package ss.week4.math;

public class Homework {
	
	public static void main(String[] args) {
		LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
		Function f2 = f1.derivative();
		Function f3 = f1.integrand();
		System.out.println("f(x) = " + f1 + "; f(5) = " + f1.apply(5));
		System.out.println("f'(x) = " + f2 + "; f'(5) = " + f2.apply(5));
		System.out.println("F(x) = " + f3 + "; F(5) = " + f3.apply(5));
		
		double[] g1parts = new double[]{1,1,1,1};
		Polynomial g1 = new Polynomial(g1parts);
		Function g2 = g1.derivative();
		Function g3 = g1.integrand();
		System.out.println("g(x) = " + g1 + "; g(5) = " + g1.apply(5));
		System.out.println("g'(x) = " + g2 + "; g'(5) = " + g2.apply(5));
		System.out.println("G(x) = " + g3 + "; G(5) = " + g3.apply(5));
		
		double[] h1parts = new double[]{5,7,6,8};
		Polynomial h1 = new Polynomial(h1parts);
		Product h2 = new Product(g1, h1);
		Function h3 = h2.derivative();
		System.out.println("h(x) = " + h2 + "; g(5) = " + h2.apply(5));
		System.out.println("h'(x) = " + h3 + "; g'(5) = " + h3.apply(5));
		
	}

}
