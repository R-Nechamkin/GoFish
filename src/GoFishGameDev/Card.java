package GoFishGameDev;
public Class Card {
	private String rank;
	private String suit;
	
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	String getRank() {
		return this.rank;
	}

	String getSuit() {

		return this.suit
	}

	String toString() {
		return this.rank + " of " + this.suit;
	}
	

}
