package GoFishGameDev;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	//field
	private List<Card>cards;
	//set array of suits and ranks
	String[] deckSuit = "Hearts,Clubs,Spades,Diamonds".split(",");
	String[] deckRank = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
	
	public Deck() {
		//fill arraylist so its deck of cards
		cards = new ArrayList<Card>();
		for (String suit : deckSuit) {
			for (String rank : deckRank) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}
	
	public Card drawCard(){
		//draw a card and remove it from deck
		Card currentCard = cards.get(cards.size()-1);
		cards.remove(currentCard);
		return currentCard;
	}

	
	public void shuffleDeck(){
		//shuffle deck
		Collections.shuffle(cards);
	}
	
	public int cardCount(){
		//return size of deck
		return cards.size();
	}
	

}
