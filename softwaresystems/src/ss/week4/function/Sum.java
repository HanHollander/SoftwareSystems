package ss.week4.function;

public class Sum implements Function {

	private Function f1;
	private Function f2;
	
	public Sum(Function f1, Function f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public double apply() {
		return f1.apply() + f2.apply();
	}

	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}

}
