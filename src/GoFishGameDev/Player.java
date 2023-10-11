package GoFishGameDev;

import java.util.List;
import java.util.Set;

public interface Player {
	String getName();
    List<Card> getHand();
    Set<String> getMatches();
    
    void addToHand(Card card);
	int askForCard(Player asker, String rank);
    void play(Player other, Deck deck);


}
