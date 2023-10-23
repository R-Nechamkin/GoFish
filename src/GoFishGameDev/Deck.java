package GoFishGameDev;

public Class Deck {
	private List<Card>cards;
	private int numCards = 0;
	
	String[] deckSuit = "Hearts,Clubs,Spades,Diamonds".split(",");
	String[] deckRank = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
	
	public Deck() {
		cards = new ArrayList<Card>();
		for (String suit : deckSuit) {
			for (String rank : deckRank) {
				Card card = new Card(deckRank, deckSuit);
				cards.add(card);
				cardCount ++;
			}
		}
	}

	void shuffleDeck();{
		Collections.shuffle(cards);
	}
	
	public cardCount{
		return cardCount;
	}
	

}
