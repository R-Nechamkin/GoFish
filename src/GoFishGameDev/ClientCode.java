package GoFishGameDev;
import java.util.*;

public class ClientCode {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		do  {
			System.out.println("What is your name?");
			String humanName = keyboard.nextLine();
			List<Player> players = new ArrayList<>();
			players.add(new HumanPlayer(humanName, new ArrayList<Card>()));
			players.add(new ComputerPlayer("The computer", new ArrayList<Card>()));
			StandardDeck deck = new StandardDeck();

			Game game = new GoFishGame(players, deck);
			game.startGame();
			
		}while (ask(keyboard, "play GoFish against the computer again", "quit the program"));
		
		System.out.println("Goodbye.");
	}
	
	
	/**
	 * This message asks the user if they would like to do something
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @param message   A String describing what the user is being asked to do
	 * @param nMessage  A String describing what will happen if the user indicates they do not wish to do the action
	 * @return {@code true} if the user wishes to do the action or {@code false} if the user does not
	 */
	public static boolean ask(Scanner keyboard, String message, String nMessage) {
		System.out.print("Would you like to " + message + "? (Y/N) ");
		char response = keyboard.nextLine().toUpperCase().charAt(0);
		while (response != 'Y' && response != 'N') {
			System.out.print(
					"Error! You have entered an invalid response. Please type Y to " + message + " or N to " + nMessage + ". ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
		}
		if (response == 'Y') {
			return true;
		}
		return false;
	}
}
