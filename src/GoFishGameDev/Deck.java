package GoFishGameDev;

public class Deck {
	//fields
	private List<Card>cards;
	private int numCards = 0;
	//set ranks and suits as arrays
	String[] deckSuit = "Hearts,Clubs,Spades,Diamonds".split(",");
	String[] deckRank = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
	//constructor
	public Deck() {
		//build deck of cards
		cards = new ArrayList<Card>();
		for (String suit : deckSuit) {
			for (String rank : deckRank) {
				Card card = new Card(deckRank, deckSuit);
				cards.add(card);
				cardCount ++;
			}
		}
	}
//shuffle deck
	public void shuffleDeck();{
		Collections.shuffle(cards);
	}
	public cardCount{
		//cardcounter
		return cardCount;
	}
	

}
