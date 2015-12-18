package ss.week6.voteMachine;

import java.io.*;
import java.util.*;

public class VoteList extends Observable{
	
	private HashMap<String, Integer> voteList;
	
	public VoteList() {
		voteList = new HashMap<String, Integer>();
	}
	
	public void addVote(String party) {
		Set<String> keySet = voteList.keySet();
		if (keySet.contains(party)) {
			voteList.replace(party, voteList.get(party) + 1);
		} else {
			voteList.put(party, 1);
		}
		setChanged();
		notifyObservers("vote");
	}
	
	public HashMap<String, Integer> getVotes() {
		return voteList;
	}
	
	public void addParty(String party) {
		voteList.put(party, 0);
	}
	

}
