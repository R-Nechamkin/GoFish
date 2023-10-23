package GoFishGameDev;
public class Card {
//fields
	private String rank;
	private String suit;
//constructor
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
//getRank
	public String getRank() {
		return this.rank;
	}
//getSuit
	public String getSuit() {

		return this.suit;
	}
//toString
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	

}
