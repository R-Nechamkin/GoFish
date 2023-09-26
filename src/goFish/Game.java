package goFish;

import java.util.List;

public interface Game {
  //  protected List<Player> players;
//    protected Deck deck;

    public void startGame();
    public boolean isGameOver();
    public void playTurn(Player p);
    public void endGame();
}
