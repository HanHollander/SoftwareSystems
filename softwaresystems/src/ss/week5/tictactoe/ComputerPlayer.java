package ss.week5.tictactoe;

public class ComputerPlayer extends Player {
	
	private Mark mark;
	private Strategy strategy;
	private String name;
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark, mark);
		this.strategy = strategy;
	}
	
	public ComputerPlayer(Mark mark) {
		super("Naive strategy-" + mark, mark);
		this.strategy = new NaiveStrategy();
	}
	
	public int determineMove(Board board) {
		return strategy.determineMove(board, mark);
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}

}
