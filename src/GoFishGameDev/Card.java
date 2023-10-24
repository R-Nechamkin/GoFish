package GoFishGameDev;
public class Card implements CardInterface{
//fields
	private String rank;
	private String suit;
//constructor
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
//getRank
	@Override
	public String getRank() {
		return this.rank;
	}
//getSuit
	@Override
	public String getSuit() {

		return this.suit;
	}
//toString
	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	

}
