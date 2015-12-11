package ss.week5.tictactoe;

import java.util.*;

public class NaiveStrategy implements Strategy {

	//@ensures \result == "Naive strategy";
	public String getName() {
		return "Naive strategy";
	}

	//@ensures emptyFields.contains(\result);
	//@ensures \result >= 0 && \result <= 8;
	//@ensures isEmptyField(\result) == true;
	public int determineMove(Board b, Mark m) {
		int result = -1;
		Set<Integer> emptyFields = new HashSet<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
			}
		}
		while (!emptyFields.contains(result)) {
			result = (int)(Math.random() * 9);
		}
		return result;
	}
}
