package ss.week4.function;

public class LinearProduct extends Product {
	
	private Constant f1;
	private Function f2;
	
	public LinearProduct(Constant f1, Function f2) {
		super(f1, f2);
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public Function derivative() { 
		return new Product(f1, f2.derivative());
	}

}
