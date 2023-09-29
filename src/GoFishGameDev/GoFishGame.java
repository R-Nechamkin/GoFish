package GoFishGameDev;
import java.util.List;

public class GoFishGame implements Game {
    private List<Player> players;
    private Deck deck;

    public GoFishGame(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        // Implement the game initialization here
    }

    @Override
    public boolean isGameOver() {
        // Implement the game-over condition here
        return false; // Replace with your condition
    }

    @Override
    public void playTurn(Player player) {
        // Implement the game logic for playing a turn here
    }

    @Override
    public void endGame() {
        // Implement game-ending actions here
    }
}
