package GoFishGameDev;

public interface Game {
//interface for both humanPlayer and compPlayer to play game from
	void startGame();
    boolean isGameOver();
    void playTurn(Player player);
    void endGame();
}
