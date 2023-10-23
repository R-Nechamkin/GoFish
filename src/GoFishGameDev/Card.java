package GoFishGameDev;
public class Card {
	private String rank;
	private String suit;
	
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public String getRank() {
		return this.rank;
	}

	public String getSuit() {

		return this.suit;
	}

	public String toString() {
		return this.rank + " of " + this.suit;
	}
	

}
