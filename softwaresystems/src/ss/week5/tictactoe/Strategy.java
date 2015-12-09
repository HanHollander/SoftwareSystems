package ss.week5.tictactoe;

public interface Strategy {
	
	public String getName();
	
	public int determineMove(Board b, Mark m);

}
