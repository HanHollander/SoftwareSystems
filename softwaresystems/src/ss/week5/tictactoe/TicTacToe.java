package ss.week5.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
    	if (args.length > 1){
    		Player p1;
    		Player p2;
    		String n1 = args[0];
    		String n2 = args[1];
    		String naive = "-N";
    		String smart = "-S";
    		if (n1.equals(naive)) {
    			p1 = new ComputerPlayer(Mark.OO);
    		} else if (n1.equals(smart)) {
    			p1 = new ComputerPlayer(Mark.OO, new SmartStrategy());
    		} else {
    			p1 = new HumanPlayer(n1, Mark.OO); // "Wijtse", Mark.OO);
    		}
    		if (n2.equals(naive)) {
    			p2 = new ComputerPlayer(Mark.XX);
    		} else if (n2.equals(smart)) {
    			p2 = new ComputerPlayer(Mark.XX, new SmartStrategy());
    		} else {
    			p2 = new HumanPlayer(n2, Mark.XX); // "Wijtse", Mark.OO);
    		}
            Game game = new Game(p1, p2);
            game.start();
    	}
    }
}
