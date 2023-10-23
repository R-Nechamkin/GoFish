package GoFishGameDev;
import java.util.*;

public class GoFishGame implements Game {
	//fields
    private List<Player> players;
    private Deck deck;

    public GoFishGame(List<Player> players, Deck deck) {
	//constructor
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        // begin game, show instructs, player starts
	    deck.shuffleDeck();
        		System.out.println("Welcome to GoFish!");
		Scanner input = new Scanner(System.in);
		System.out.println("Menu: \r\n"
				+ "1) Instructions \r\n"
				+ "2) Start Game");
		int menuOption = input.nextInt();
		while (menuOption != 1 && menuOption != 2) {
			System.out.println("Invalid Entry. Please input 1 or 2.");
			System.out.println("Menu: \r\n"
					+ "1) Instructions \r\n"
					+ "2) Start Game");
			menuOption = input.nextInt();
		}
		if (menuOption == 1) {
			System.out.println(
		"During a turn, you can ask for a specific rank of a card. \r\n"
		+ "If the other player has it, they must give you all of them. \r\n"
		+ "If not, then you have to go fish, or pick a card from the deck.\r\n"
		+ "You get another turn if you don't have to go fish. \r\n"
		+ "When you get all four suits of that specific rank, then you have a set, and you put it aside. \r\n"
		+ "You win the game when one player runs out of cards, or when there are no more cards in the middle. \r\n"
		+ "Whoever has the most sets is the winner!");
		}
		else {
			System.out.println("Let's Start!");
			System.out.println("Player, you go first.");
			
			playTurn(Player player);
			
		}
		input.close();
    }

    @Override
    public boolean isGameOver() {
              // if no cards left-gameover
    	boolean gameOver = false;
    	//when all the cards are used
    	if (deck.cardCount() == 0) {
    		gameOver = true;
    	}
    	  
    	//if players have no cards left-gameover
		for (Player p: players){
		if (p.getHand().isEmpty())
			gameOver = true;
		}
        return gameOver;
    }
    
    @Override
    public void playTurn() {
	    //start players turn
	    while(!isGameOver()) {
	    	players.get(0).play(players.get(1), deck);
	    	System.out.println("Human, go.");
	    	players.get(1).play(players.get(0), deck);
	    	System.out.println("The computer is going.");
	    }
    }

    @Override
    public void endGame() {
	    //end game, find and display winner
	    String winner;
        System.out.println("Game over!")
	if (players.get(0).getNumMatches() > players.get(1).getNumMatches() ){
		winner = "Human Player";
    }
	    else if (players.get(0).getNumMatches() > players.get(1).getNumMatches()) {
		    winner = "Computer";
	    }
	    else {
		    winner = "Tie";
	    }
	    System.out.println("Winner: " + winner + "!!");
}




