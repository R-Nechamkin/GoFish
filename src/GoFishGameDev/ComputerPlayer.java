package GoFishGameDev;
import java.util.List;

public class ComputerPlayer implements Player {
    private String name;
    private List<Card> hand;

    public ComputerPlayer(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }

    @Override
    public void addToHand(Card card) {
        hand.add(card);
    }

    @Override
    public void play() {
        // Implement the player's behavior here
        // This method is left empty for you to define the player's actions in the game
    }
}
