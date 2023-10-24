package GoFishGameDev;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HumanPlayer implements Player {
	 String name;
	 List<Card> hand;
	 Set<String> matches = new HashSet<>();

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
	public Set<String> getMatches() {
		return matches;
	}
	
    public int getNumMatches() {
    	return matches.size();
    }


	@Override
	public void addToHand(Card card) {
		hand.add(card);
	}


	/*
	 * This method asks a player for a card and adds those cards to the hand
	 */
	@Override
	public int askForCard(Player asker, String rank) {
		int catches = 0;
		System.out.println(asker.getName() + " has asked you for " + rank);
		for (int i =0; i < hand.size(); i++) {
			if (hand.get(i).getRank().equals(rank)) {
				asker.addToHand(hand.get(i));
				hand.remove(hand.get(i));
				catches++;
			}
		}
		if (catches > 0)
			System.out.println("You have given " + asker.getName() + " the " + catches + " " + rank + " which you had");
		else
			System.out.println("Since you have none of this card, you tell " + asker.getName() + " to go fish!");
		return catches;		
	}


	@Override
	public void play(Player computer, StandardDeck deck) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("It is your turn.");
		showCardsIfWant(keyboard);
		
		String rank = pickCard(keyboard);

		System.out.println("Asking the computer for a " + rank + "...");
		System.out.println("Press Enter to continue");
		keyboard.nextLine();
		int catches = computer.askForCard(this, rank);	

		if (catches == 0) {
			System.out.println("The computer does not have any of your cards. Go Fish!");
			Card drawn = deck.drawCard();
			System.out.println("You drew a " + drawn.getRank() + " of " + drawn.getSuit() + ".");
			addToHand(drawn);
		}
		else {
			System.out.println("You got " + catches + " of your card from the computer");
			if (countCards(hand, rank) == 4) {
				System.out.println("You now have a full set of " + rank + "s.");
				matches.add(rank);
			}
		}
		
		System.out.println("Your turn is now over.");
	}
	
	/**
	 * This method asks the user if they wish to see the cards in their hand
	 * @param keyboard a {@code Scanner} object representing the keyboard	 
	 */
	private void showCardsIfWant(Scanner keyboard) {
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
	}
	
	/**
	 * This method is used to allow the user to pick which rank to request from the user
	 * The method interacts with the user from the console
	 * @param keyboard a {@code Scanner} object representing the keyboard
	 * @return the rank the user wishes to request from the computer
	 */
	private String pickCard(Scanner keyboard) {

		final List<String> values = new ArrayList<>();
		values.add("2");
		values.add("3");
		values.add("4");
		values.add("5");
		values.add("6");
		values.add("7");
		values.add("8");
		values.add("9");
		values.add("10");
		values.add("J");
		values.add("Q");
		values.add("K");
		values.add("A");

		System.out.println("What card would you like to ask for? Please enter the number of your card. ");
		String rank = keyboard.nextLine();
				while (!(values.contains(rank)) || !(containsRank(hand, rank)) || matches.contains(rank)){
			if (!(values.contains(rank))) {
				System.out.print(
					"Error! No card exists with that name. Please type the rank of your card. "
							+ "\nFor face cards, type the uppercase first letter of the rank.");
			}
			else if (!(containsRank(hand, rank))){
				System.out.print(
						"Error! You may only ask for a card which you have in your hand. Please type the rank of your card. "
								+ "\nFor face cards, type the uppercase first letter of the rank.");
			}
			else {
				System.out.print(
						"Error! You already have 4 of these cards. Please type the rank of your card. "
								+ "\nFor face cards, type the uppercase first letter of the rank.");
			}
			rank = keyboard.nextLine().toUpperCase();
		}

		return rank;
	}
	
	/**
	 * This method checks whether a list of cards contains a card of a certain rank
	 * @param cards
	 * @param rank
	 * @return {@code true} if the cards contains the rank; {@code false} otherwise
	 */
	private boolean containsRank(List<Card> cards, String rank) {
		for (Card c: cards) {
			if (c.getRank().equals(rank))
				return true;
		}
		return false;
	}
	
	/**
	 * This method counts how many cards of a certain rank there are in a list of cards
	 * @param cards
	 * @param rank
	 * @return
	 */
	private int countCards(List<Card> cards,String rank) {
		int count = 0;
		for (Card c: cards) {
			if (c.getRank().equals(rank)) count++;
		}
		return count;
	}
}
