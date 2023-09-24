package goFish;

import java.util.List;

public interface Deck {
    private List cards;

    public Card drawCard();
    public void shuffleDeck();
  }
