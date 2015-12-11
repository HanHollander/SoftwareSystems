package ss.week5.tictactoe;

import java.util.*;

public class SmartStrategy implements Strategy {

	//@ensures \result == "Naive strategy";
	public String getName() {
		return "Smart strategy";
	}

	//@ensures emptyFields.contains(\result);
	//@ensures \result >= 0 && \result <= 8;
	//@ensures isEmptyField(\result) == true;
	public int determineMove(Board b, Mark m) {
		int result = -1;
		boolean determined = false;
		Set<Integer> emptyFields = new HashSet<Integer>();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
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
			for (int i = 0; i < Board.DIM * Board.DIM; i++) {
				if (b.isEmptyField(i)) {
					emptyFields.add(i);
				}
			}
			while (!emptyFields.contains(result)) {
				result = (int)(Math.random() * 9);
			}
		}
		return result;
	}
}
