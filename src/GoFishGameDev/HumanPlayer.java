package GoFishGameDev;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private String name;
    private List<Card> hand;

    public HumanPlayer(String name, List<Card> hand) {
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
    	Scanner keyboard = new Scanner(System.in);
    	Player computer = new ComputerPlayer("computer", null);
    	Deck deck = new Deck();
    	
    	List<String> ranks = new ArrayList<>();
    	ranks.add("2");
    	ranks.add("3");
    	ranks.add("4");
    	ranks.add("5");
    	ranks.add("6");
    	ranks.add("7");
    	ranks.add("8");
    	ranks.add("9");
    	ranks.add("10");
    	ranks.add("JACK");
    	ranks.add("QUEEN");
    	ranks.add("KING");
    	ranks.add("ACE");
    	
  /*  	
    	List<String> suits = new ArrayList<>();
    	ranks.add("SPADES");
    	ranks.add("DIAMONDS");
    	ranks.add("HEARTS");
    	ranks.add("CLUBS");
    */	
        System.out.println("It is your turn.");
        
        System.out.println("Would you like to see your cards? (Y/N) ");
		char seeCards = keyboard.nextLine().toUpperCase().charAt(0);
		while (seeCards != 'Y' && seeCards != 'N') {
			System.out.print(
					"Error! You have entered an invalid response. Please type Y to see the cards in your hand or N to continue.");
			seeCards = keyboard.nextLine().toUpperCase().charAt(0);
		}
		if (seeCards == 'Y') {
			System.out.println("Here are your cards");
			for(Card c: hand) {
				System.out.println("The " + c.getRank() + " of " + c.getSuit());
			}
		}
		
		System.out.println("What card would you like to ask for? Please enter the number of your card. ");
		String cardVal = keyboard.nextLine().toUpperCase();
		while (!(ranks.contains(cardVal))){
			System.out.print(
					"Error! You have entered an invalid response. Please type the rank of your card. "
					+ "\nFor face cards, type the full name of the rank.");
			cardVal = keyboard.nextLine().toUpperCase();
		}
		System.out.println("Asking the computer for a " + cardVal + "...");
		System.out.println("Press Enter to continue");
		keyboard.nextLine();
		int catches = askForCard(computer, cardVal);	
		
		if (catches == 0) {
			System.out.println("The computer does not have any of your cards. Go Fish!");
			Card drawn = deck.drawCard();
			System.out.println("You drew a " + drawn.getRank() + " of " + drawn.getSuit() + ".");
			System.out.println("Your turn is over.");
		}
		else {
			System.out.println("You got " + catches + " of your card from the computer");
		}
    }
    
    /*
     * This method asks a player for a card and adds those cards to the hand
     */
    private int askForCard(Player p, String rank) {
    	int catches = 0;
    	List<Card> hand = p.getHand();
    	for (int i =0; i < hand.size(); i++) {
    		if (hand.get(i).getRank() == rank) {
    			addToHand(hand.get(i));
    			p.removeFromHand(hand.get(i));
    			catches++;
    		}
    	}
    	return catches;
    }

	@Override
	public void removeFromHand(Card card) {
		// TODO Auto-generated method stub
		
	}
    
}
