package GoFishGameDev;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ComputerPlayer implements Player {
     String name;
     List<Card> hand;
     Set<String> matches;
    
    // These variables are used to help the computer make strategic gameplay decisions
     HashMap<String, Integer> handMap;	// a map of the ranks the computer has and how many cards of each rank it has
     Set<String>  humanAsked = new HashSet<>();  // stores which cards the human has asked for
     HashMap<String, Integer> computerAsked = new HashMap<>();  // stores which cards the computer has already asked for but the human did not have and the last turn the computer asked for them
     int currTurn;
    
    public ComputerPlayer(String name, List<Card> hand) {
        this.name = name;       
        this.hand = hand;
        handMap = new HashMap<String, Integer>();
        for (Card c: hand) {
        	addToHand(c);        
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }
    
    public int getNumMatches() {
    	return matches.size();
    }

    @Override
    public void addToHand(Card card) {
        hand.add(card);
        int frequency = handMap.getOrDefault(card, 1);
        frequency ++;
        handMap.put(card.getRank(), frequency);
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
    	
    	int catches = human.askForCard(this, rankAsked); 
    	if (catches == 0) {
    		computerAsked.put(rankAsked, currTurn);
    		addToHand(deck.drawCard());
    	}
    	else {
        	handMap.put(rankAsked, handMap.get(rankAsked)+ catches);
        	if (handMap.remove(rankAsked, 4)) {
        		matches.add(rankAsked);
        	}
    	}
    	
    }
    
    /*
     * This method decides which card to ask for
     */
    /**
     * The computer uses this method to decide which card to ask for
     * @param otherPlayer a {@code Player} object representing the other player in the game
     * @return the rank of cards to ask for
     */
    private String computerLogic(Player otherPlayer) {
    	HashMap<String, Integer> cardPriorities = new HashMap<>();
    	for (String rank: handMap.keySet()) {
    		int priority = 1;

    		if (handMap.get(rank) == 2) priority +=3;
    		if (handMap.get(rank) == 3) priority ++;

    		if (humanAsked.contains(rank)) priority +=2;

    		if (computerAsked.containsKey(rank)) {
    			if ((currTurn - computerAsked.get(rank)) < 4) priority -=2;
    			else if ((currTurn - computerAsked.get(rank)) < 10) priority --;
    		}
			cardPriorities.put(rank, Integer.valueOf(priority));
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
    	// We need to create a List of the keys so that we make sure maxKey is some key
    	// If we just set maxKey to null, we'll run into a problem if no key has maxPriority
    	List<String> keyArray = new ArrayList<>(map.keySet());
    	String maxKey = keyArray.get(0);
    	int maxValue = Integer.MIN_VALUE;
    	for (String s: keyArray) {
    		if (map.get(s) > maxValue) {
    			maxValue = map.get(s);
    			maxKey = s;
    		}
    	}
    	return maxKey;
    }


}
