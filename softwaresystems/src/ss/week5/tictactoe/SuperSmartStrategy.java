package ss.week5.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class SuperSmartStrategy implements Strategy {

	
	public String getName() {
		return "Super smart strategy";
	}

	
	public int determineMove(Board b, Mark m) {
		int result = -1;
		boolean determined = false;
		Set<Integer> emptyFields = new HashSet<Integer>();
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			if (b.isEmptyField(i)) {
				emptyFields.add(i);
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
			for (int field : emptyFields) {
				
			}
		}
		return result;
	}
}
