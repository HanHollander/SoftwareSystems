package ss.week5.tictactoe;

import java.util.*;

public class SuperSmartStrategy implements Strategy {

	
	public String getName() {
		return "Super smart strategy";
	}

	int count;
	public int determineMove(Board b, Mark m) {

		int result = -1;
		boolean determined = false;
		Set<Integer> emptyFields = new HashSet<Integer>();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		
		if (!determined){						// If one field left
			if (emptyFields.size() == 1) {
				for (int field : emptyFields) {
					result = field;
					determined = true;
				}
			}
		}
		
		if (!determined){						// If instant win available
			for (int field : emptyFields) {
				Board copy = b.deepCopy();
				copy.setField(field, m);
				if (copy.gameOver()) {
					result = field;
					determined = true;
				}
			}
		}
		if (!determined) {						// If instant lose available
			Mark other;
			if (m == Mark.OO) {
				other = Mark.XX;
			} else {
				other = Mark.OO;
			}
			for (int field : emptyFields) {
				Board copy = b.deepCopy();
				copy.setField(field, other);
				if (copy.gameOver()) {
					result = field;
					determined = true;
				}
			}
		} 
		if (!determined){
			int realCount = 0;
			int thisMoveChance;
			int thisMoveEnemyChance;
			ArrayList<Integer> bestMoveYet = new ArrayList<Integer>();
			if (iStarted(b, m)) {
				bestMoveYet.add(-1);
				bestMoveYet.add(-1);
				System.out.println("Win chance:");
				System.out.println("  Mine: " + "Enemy:");
				count = 0;
				for (int field : emptyFields) {
					thisMoveChance = getWinChanceMove(field, b.deepCopy(), m, m);
					thisMoveEnemyChance = getWinChanceMove(field, b.deepCopy(), m, m.other());
					System.out.println(field + " " + thisMoveChance + "%   " + thisMoveEnemyChance + "%");
					if (thisMoveChance > bestMoveYet.get(1)) {
						bestMoveYet.set(0, field);
						bestMoveYet.set(1, thisMoveChance);
						realCount = count;
					}
				}
			} else {
				bestMoveYet.add(999);
				bestMoveYet.add(999);
				System.out.println("Win chance:");
				System.out.println("  Mine: " + "Enemy:");
				count = 0;
				for (int field : emptyFields) {
					thisMoveChance = getWinChanceMove(field, b.deepCopy(), m, m);
					thisMoveEnemyChance = getWinChanceMove(field, b.deepCopy(), m, m.other());
					System.out.println(field + " " + thisMoveChance + "%   " + thisMoveEnemyChance + "%");
					if (thisMoveEnemyChance < bestMoveYet.get(1)) {
						bestMoveYet.set(0, field);
						bestMoveYet.set(1, thisMoveEnemyChance);
						realCount = count;
					}
				}
			}
			System.out.println(realCount / 2 + " possible outcomes");
			result = bestMoveYet.get(0);
		}
		return result;
	}
	
	private int getWinChanceMove(int move, Board board, Mark mark, Mark myMark) {
		board.setField(move, mark);
		int result;
		
		count = count + 1;
		
		Set<Integer> emptyFields = new HashSet<Integer>();
		
		for (int i = 0; i < board.DIM * board.DIM; i++) {
			if (board.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		
		
		if (board.gameOver()) {
			if (board.isWinner(myMark)) {
				result = 100;
			} else {
				result = 0;
			}
		} else {
			int winChanceCurrentMove;
			
			int total = 0;
			
			// Mark otherMark = mark.other();
			
			for (int field : emptyFields) {
				Board boardCopy = board.deepCopy();
				winChanceCurrentMove = getWinChanceMove(field, boardCopy, mark.other(), myMark);
				total = total + winChanceCurrentMove;
			}
			result = total / emptyFields.size();
			
		}
		
		return result;
	}
	
	private boolean iStarted(Board board, Mark mark) {
		int myTurns = 0;
		int enemyTurns = 0;
		for (int i = 0; i < board.DIM * board.DIM; i++) {
			if (board.getField(i).equals(mark)) {
				myTurns++;
			} else if (board.getField(i).equals(mark.other())) {
				enemyTurns++;
			}
		}
		return myTurns == enemyTurns;
	}
	
}
