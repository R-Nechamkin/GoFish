package goFish;

public interface Player {
  private String name;
  private List deck;

  public String getName();
  public List<Card> getHand();
  public addToHand(Card);
  public play();
}
