package GoFishGameDev;

public interface Deck {

	Card drawCard();
	void shuffleDeck();
	int cardCount();

}