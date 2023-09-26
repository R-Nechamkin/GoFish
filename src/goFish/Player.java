package goFish;

import java.util.List;

public interface Player {
//  private String name;
//  private List<Card> deck;

  public String getName();
  public List<Card> getHand();
  public void addToHand(Card c);
  public void play();
}
