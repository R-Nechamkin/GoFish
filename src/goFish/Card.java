package goFish;

public interface Card {
  private String rank;
  private String suit;

  public Card(rank, suit);
  public String getRank();
  public String getSuit();
  public String toString();
}
