package ss.week4.function;

public class Product implements Function {
	
	private Function f1;
	private Function f2;
	
	public Product(Function f1, Function f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	public double apply() {
		return f1.apply() * f2.apply();
	}

	public Function derivative() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
