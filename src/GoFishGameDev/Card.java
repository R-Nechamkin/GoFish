package GoFishGameDev;
import java.util.*;
public interface Card {
	 String getRank(){
		String[] deckNums = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		 Random randRank = new Random();
    		int randomNumber = randRank.nextInt(deckNums.length);
   		 String rank = deckNums[randomNumber];
   		 return rank;
	 }
	 String getSuit(){
	 String[] deckSuit = "Hearts,Clubs,Spades,Diamonds".split(",");
		 Random randSuit = new Random();
    		int randomNumber = randSuit.nextInt(deckSuit.length);
   		 String suit = deckSuit[randomNumber];
   		 return suit;
	 }
	 String toString(){
	 return "Card{rank + "of " + suit}"
	 }
	

}
