package GoFishGameDev;

public interface Deck {

	String[] deck = new String[52]

	Card drawCard() {
		Card currentCard = new Card();
		while (deck.includes(currentCard)) {
			Card currentCard = new Card();
		}
		deck.add(currentCard);
	}

	void shuffleDeck();{
		deck.clear();
	}

}
