package ss.week2;

public class Rectangle {
	
	//@ invariant width() > 0;
	//@ invariant length() > 0;
	
	// -ATTRIBUTES- \\
	
	private /*@ spec_public */ int length;
	private /*@ spec_public */ int width;
	
	// -CONSTRUCTOR- \\
	
	//@ requires length > 0;
	//@ requires width > 0;
	public Rectangle(int length, int width) {
		assert width > 0;
		assert length > 0;
		this.length = length;
		this.width  = width;
	}
	
	// -MAIN- \\
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(10,-10);
		System.out.println(rect.width());
	}
	
	// -METHODS- \\
	
	//@ pure
	public int length() {
		return length;
	}
	
	//@ pure
	public int width() {
		return width;
	}
	
	//@ ensures \result == width() * length();
	public int area() {
		return length * width;
	}
	
	//@ ensures \result == 2 * length() + 2 * width();
	public int perimeter() {
		return 2 * length + 2 * width;
	}
}
