package GoFishGameDev;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private List<Card>cards;
	private int cardCount = 0;
	
	String[] deckSuit = "Hearts,Clubs,Spades,Diamonds".split(",");
	String[] deckRank = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
	
	public Deck() {
		cards = new ArrayList<Card>();
		for (String suit : deckSuit) {
			for (String rank : deckRank) {
				Card card = new Card(suit, rank);
				cards.add(card);
				cardCount ++;
			}
		}
	}
	
	public Card drawCard(ArrayList cards){
		cards[i];	
	}

	
	public void shuffleDeck(){
		Collections.shuffle(cards);
	}
	
	public int cardCount(){
		return cardCount;
	}
	

}
