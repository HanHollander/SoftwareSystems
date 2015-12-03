package ss.week4.math;

public class Sum implements Function, Integrandable {

	private Function f1;
	private Function f2;
	
	public Sum(Function f1, Function f2) {
		this.f1 = f1;
		this.f2 = f2;
	}
	
	public double apply(double x) {
		return f1.apply(x) + f2.apply(x);
	}

	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	
	public String toString() {
		return f1.toString() + " + " + f2.toString();
	}

	public Function integrand() {
		Function result = null;
		if (f1 instanceof Integrandable && f2 instanceof Integrandable) {
			result = new Sum(((Integrandable)f1).integrand(), ((Integrandable)f2).integrand());
		}
		return result;
	}

}
