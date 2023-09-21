package goFish;

  public interface Game {
    protected List<Player> players;
    protected Deck deck;

    public startGame();
    public boolean isGameOver();
    public playTurn(Player);
    public endGame();
}
