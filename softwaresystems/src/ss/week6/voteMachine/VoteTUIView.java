package ss.week6.voteMachine;

import java.util.*;

public class VoteTUIView implements VoteView, Observer {
	
	private VoteMachine voteMachine;
	
	public VoteTUIView(VoteMachine voteMachine) {
		this.voteMachine = voteMachine;
	}
	
	public void start() {
		boolean goOn = true;
		while (goOn) {
			String prompt = "Insert valid command:";
			String answer;
			do {
	            System.out.print(prompt);
	            Scanner scanner = new Scanner(System.in); {
	                answer = scanner.hasNextLine() ? scanner.nextLine() : null;
	            }
	        } while (answer == null || (!answer.contains("VOTE") && !answer.contains("ADD PARTY") && !answer.contains("VOTES")
	        		&& !answer.contains("PARTIES") && !answer.contains("EXIT") && !answer.contains("HELP")));
			if (answer.contains("VOTE ")) {
				answer = answer.substring(5);
				voteMachine.vote(answer);
			} else if (answer.contains("ADD PARTY ")) {
				answer = answer.substring(10);
				voteMachine.addParty(answer);
			} else if (answer.contains("VOTES")) {
				voteMachine.getVotes();
			} else if (answer.contains("PARTIES")) {
				voteMachine.getParties();
			} else if (answer.contains("EXIT")) {
				goOn = false;
			} else if (answer.contains("HELP")) {
				System.out.println("I won't help you mate!!");
			}
		}
	}
	
	public void showVotes(Map<String, Integer> voteList) {
		Set<String> keySet = voteList.keySet();
		for (String key : keySet) {
			System.out.println(key + ": " + voteList.get(key));
		}
	}
	
	public void showParties(List<String> parties) {
		for (String party : parties) {
			System.out.println(party);
		}
	}
	
	public void showError(String error) {
		System.out.println(error);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")) {
			System.out.println("Someone voted");
		} else if (arg.equals("party")) {
			System.out.println("party added");
		} else {
			System.out.println("Someting happened");
		}
	}

}
