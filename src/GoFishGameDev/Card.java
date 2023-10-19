package GoFishGameDev;
import java.util.*;
public interface Card {
	 String getRank(){
		String[] deckNums = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		 Random ran = new Random();
    		int randomNumber = ran.nextInt(deckNums.length);
   		 String rank = deckNums[randomNumber];
   		 System.out.println(rank);
	 }
	 String getSuit();
	 String toString();

}
