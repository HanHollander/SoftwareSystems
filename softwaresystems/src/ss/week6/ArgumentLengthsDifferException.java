package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	
	
	public ArgumentLengthsDifferException(int s1length, int s2length) {
		super("error: length of command line arguments "
                + "differs (" + s1length + ", " + s2length + ")");
	}


}
