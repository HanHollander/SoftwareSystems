package ss.week5.tictactoe;

import java.util.*;

public class SmartStrategy implements Strategy {

	//@ensures \result == "Naive strategy";
	public String getName() {
		return "Smart strategy";
	}

	//@requires b != null;
	//@requires m != null;
	//@ensures emptyFields.contains(\result);
	//@ensures \result >= 0 && \result <= 8;
	//@ensures isEmptyField(\result) == true;
	//@ensures isEmptyField(4) ==> \result == 4;
	public int determineMove(Board b, Mark m) {
		int result = -1;
		boolean determined = false;
		Set<Integer> emptyFields = new HashSet<Integer>();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		} 
		if (b.isEmptyField(4)) {
			result = 4;
			determined = true;
		}
		if (!determined){
			for (int field : emptyFields) {
				Board copy = b.deepCopy();
				copy.setField(field, m);
				if (copy.gameOver()) {
					result = field;
					determined = true;
				}
			}
		}
		if (!determined) {
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
			for (int j = 0; j < Board.DIM * Board.DIM; j++) {
				if (b.isEmptyField(j)) {
					emptyFields.add(j);
				}
			}
			while (!emptyFields.contains(result)) {
				result = (int)(Math.random() * 9);
			}
		}
		return result;
	}
// 		U SCRUB!! U DISONNA FAMORY!! U WORK HARDER
//	current game situation: 
//
//		   |   |         0 | 1 | 2 
//		---+---+---     ---+---+---
//		   |   |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   |         6 | 7 | 8 
//
//
//		current game situation: 
//
//		   |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		   |   |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   |         6 | 7 | 8 
//
//
//		current game situation: 
//
//		   |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		   | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   |         6 | 7 | 8 
//
//
//		current game situation: 
//
//		   |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		 O | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   |         6 | 7 | 8 
//
//
//		current game situation: 
//
//		   |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		 O | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   | X       6 | 7 | 8 
//
//
//		current game situation: 
//
//		 O |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		 O | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		   |   | X       6 | 7 | 8 
//
//
//		current game situation: 
//
//		 O |   | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		 O | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		 X |   | X       6 | 7 | 8 
//
//
//		current game situation: 
//
//		 O | O | O       0 | 1 | 2 
//		---+---+---     ---+---+---
//		 O | X |         3 | 4 | 5 
//		---+---+---     ---+---+---
//		 X |   | X       6 | 7 | 8 
//
//		Speler Naive strategy-O (O) has won!
//
//		> Play another time? (y/n)?
}
