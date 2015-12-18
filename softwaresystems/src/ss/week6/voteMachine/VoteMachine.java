package ss.week6.voteMachine;

import java.util.*;

import ss.week6.voteMachine.gui.*;

public class VoteMachine {
	
	private PartyList partyList;
	private VoteList voteList;
	private VoteView voteView;
	
	public VoteMachine() {
		partyList = new PartyList();
		voteList = new VoteList();
		voteView = new VoteGUIView(this);
		partyList.addObserver(voteView);
		voteList.addObserver(voteView);
	}
	
	public static void main(String[] args) {
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
	}
	
	public void start(){
		voteView.start();
	}
	
	public void addParty(String party) {
		if (partyList.getParties().contains(party)){
			voteView.showError("Party already exists");
		} else {
			partyList.addParty(party);
			voteList.addParty(party);
		}
	}
	
	public void vote(String party) {
		voteList.addVote(party);
	}
	
	public void getParties() {
		List<String> parties = partyList.getParties();
		voteView.showParties(parties);
	}
	
	public void getVotes() {
		Map<String, Integer> votes = voteList.getVotes();
		voteView.showVotes(votes);
	}

}
