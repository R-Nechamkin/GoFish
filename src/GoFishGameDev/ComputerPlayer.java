package GoFishGameDev;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public class ComputerPlayer implements Player {
    private String name;
    private List<Card> hand;
    private Set<String> matches;
    
    // These variables are used to help the computer decide on strategy
    private HashMap<String, Integer> handMap = new HashMap<>();
    private Set<String>  humanAsked;  // stores which cards the human has asked for
    private HashMap<String, Integer> computerAsked;  // stores which cards the computer has already asked for but the human did not have and the last turn the computer asked for them
    private int currTurn;
    
    public ComputerPlayer(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void addToHand(Card card) {
        hand.add(card);
        if (handMap.containsKey(card.getRank()))
        	handMap.put(card.getRank(), handMap.get(card.getRank())+ 1);
        else 
        	handMap.put(card.getRank(), 1);
    }
    
	@Override
	public Set<String> getMatches() {
		return matches;
	}
    
    
	@Override
	public int askForCard(Player asker, String rank) {
		humanAsked.add(rank);
    	int catches = 0;
    	for (int i =0; i < hand.size(); i++) {
    		if (hand.get(i).getRank() == rank) {
    			Card card = hand.get(i);
    			asker.addToHand(card);
    			hand.remove(card);
    			
    			if (handMap.get(card.getRank()) > 1)
    				handMap.put(card.getRank(), handMap.get(card.getRank())- 1);
    			else
    				handMap.remove(card.getRank());
    			
    	        catches++;
    		}
    	}
    	return catches;		
	}

    @Override
    public void play(Player human, Deck deck) {
    	currTurn ++;
    	String rankAsked = computerLogic(human);
    	
    	if (human.askForCard(human, rankAsked) == 0) {
    		computerAsked.put(rankAsked, currTurn);
    		addToHand(deck.drawCard());
    	}
    	
    }
    
    /*
     * This method decides which card to ask for
     */
    /**
     * The computer uses this method to decide which card to ask for
     * @param otherPlayer
     * @return the rank of cards to ask for
     */
    private String computerLogic(Player otherPlayer) {
    	HashMap<String, Integer> cardPriorities = new HashMap<>();
    	for (String rank: handMap.keySet()) {
    		if (otherPlayer.getMatches().contains(rank)) {
    			handMap.remove(rank);
    		}

    		else {
        		int priority = 0;
        		
    			if (handMap.get(rank) == 2) priority +=3;
    			if (handMap.get(rank) == 3) priority ++;
    			
    			if (humanAsked.contains(rank)) priority +=2;
    			
    			if (computerAsked.containsKey(rank)) {
    				if ((currTurn - computerAsked.get(rank)) < 4) priority -=2;
    				else if ((currTurn - computerAsked.get(rank)) < 10) priority --;
    			}
    			cardPriorities.put(rank, Integer.valueOf(priority));
    		}
    	}
    	return max(cardPriorities);

    }
    
    /**
     * This method returns the key of a HashMap which has the greatest value associated with it
     * 	If there are multiple keys with the same value, it returns the first such key
     * @param map
     * @return
     */
    public String max(HashMap<String,Integer> map) {
    	String maxKey = null;
    	int maxValue = Integer.MIN_VALUE;
    	for (String s: map.keySet()) {
    		if (map.get(s) > maxValue) {
    			maxValue = map.get(s);
    			maxKey = s;
    		}
    	}
    	return maxKey;
    }


}
