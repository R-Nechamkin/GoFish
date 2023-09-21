package goFish;

  public interface Deck {
    private List cards;

    public Card drawCard();
    public void shuffleDeck();
  }
