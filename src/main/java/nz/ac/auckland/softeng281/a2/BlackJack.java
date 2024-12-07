package nz.ac.auckland.softeng281.a2;

import java.util.ArrayList;
import java.util.List;

/**
 * you should change this class for TASK 1, 2, 3, 4.
 */
public class BlackJack {

	private List<Participant> players;
	private Participant dealer;

	public BlackJack() {
		players = new ArrayList<>();
		dealer = new BotPlayer("Dealer"); // FIXME Task 2
		players.add(new HumanPlayer("Player1"));
		// ADDHERE Task 1
    players.add(new BotPlayer("Bot1"));
    players.add(new BotPlayer("Bot2"));
	}

	// getter setter for testing purposes
	public List<Participant> getPlayers() {
		return players;
	}

	public Participant getDealer() {
		return dealer;
	}

	public void setPlayers(List<Participant> players) {
		this.players = players;
	}

	public void setDealer(Participant dealer) {
		this.dealer = dealer;
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();
		game.start();
	}

	protected void start() {
		Utils.printBlackJack();
		// create a new deck of cards
		Deck deck = new Deck();
		String result;
		do {
			for (Participant player : players) {
				player.play(deck);
			}
			// ADDHERE Task 2
      dealer.play(deck);

			checkWinner();
			System.out.println("Do you want to play again?");
			result = Utils.scanner.next();
			while (!result.equals("yes") && !result.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				result = Utils.scanner.next();
			}
		} while (result.equals("yes"));
		printPlayerHighestGain();
	}

	public void checkWinner() {
		// TODO Task 3
    
		for (Participant player : players) { // KEEPTHIS
			// ADDHERE
      int playerScore=player.getCurrentHand().getScore();
    int dealerScore=dealer.getCurrentHand().getScore();
      if (player.getCurrentHand().isBlackJack() || dealerScore>21 && playerScore<=21 || dealerScore<=21 && playerScore<=21 && playerScore>dealerScore){
        
			System.out.println(player.getName() + " wins"); // UNCOMMENT AND KEEPTHIS
      }
    }
	}

	public void printPlayerHighestGain() {
		// TODO Task 4

    String name="";
    double bet=0;
    double totalGain=0;
    double [] betArray;
    betArray=new double[3];
    List <Hand> dealerHand = dealer.getHands();


    for (int i = 0; i< players.size(); i++) {
      List<Hand> playerHand=players.get(i).getHands();
      for (int j=0; j<playerHand.size();j++){
      int playerScore=playerHand.get(j).getScore();
      int dealerScore=dealerHand.get(j).getScore();
      bet=playerHand.get(j).getBet();

      if (playerHand.get(j).isBlackJack()){
         
          betArray[i]=betArray[i]+1.5*bet;
        }
        else if (dealerScore>21 && playerScore<=21 || dealerScore<=21 && playerScore<=21 && playerScore>dealerScore){
          
          betArray[i]=betArray[i]+bet;
         }
        else {
        betArray[i]=betArray[i]-bet;
        
        }
      }
    }

      // set maximum with the first value
      double highestGain = betArray[0]; 

      // maximum value gets replaced in for loop
      for (int z = 0; z<3; z++){
        if (highestGain < betArray[z]){
          highestGain = betArray[z];
        }
        else {
          highestGain= betArray[0];
        }
      }
      
  if (highestGain == betArray[0]){
    name = players.get(0).getName();
    totalGain = highestGain;
  }
else if (highestGain == betArray[1]){
    name = players.get(1).getName();
    totalGain = highestGain;
  }
  else if (highestGain == betArray[2]){
    name = players.get(2).getName();
    totalGain = highestGain;
  }
      
		System.out.println("The player with the highest gain is: " + name + " with " + totalGain + " chips"); // UNCOMMENT AND KEEPTHIS
	}
} 



