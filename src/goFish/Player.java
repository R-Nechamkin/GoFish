package goFish;

import java.util.List;

public interface Player {
  private String name;
  private List deck;

  public String getName();
  public List<Card> getHand();
  public void addToHand(Card);
  public void play();
}
