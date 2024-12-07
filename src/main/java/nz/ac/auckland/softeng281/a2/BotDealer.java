package nz.ac.auckland.softeng281.a2;

import java.util.List;
import java.util.Random;

/**
 * you should change this class for TASK 2
 */
public class BotDealer extends Participant {

	private List<Participant> players;

	public BotDealer(String name, List<Participant> players) {
		super(name);
		//ADDHERE
    this.players=players;
	}

	@Override
	public Action decideAction() {
		// TODO
		int p1=players.get(0).getCurrentHand().getScore();
    int b1=players.get(1).getCurrentHand().getScore();
    int b2=players.get(2).getCurrentHand().getScore();
    int d=getCurrentHand().getScore();
    
     if (d>21 && p1>21 && b1<=21 && b2<=21){
        return Action.HIT;
      }
      else if (d>21 && p1<=21 && b1>21 && b2<21){
     return Action.HIT; 
      }
      else if (d>21 && p1<=21 && b1<=21 && b2>21){
     return Action.HIT; 
      }
      else if (d>21 && p1<=21 && b1<=21 && b2<=21){
     return Action.HIT;
      }
      else if (d<=21 && p1<=21 && b1<=21 && b2<=21 && d>p1 && d<b1 && d<b2){
        return Action.HIT;
      }
      else if (d<=21 && p1<=21 && b1<=21 && b2<=21 && d<p1 && d<b1 && d>b2){
        return Action.HIT;
      }
      else if (d<=21 && p1<=21 && b1<=21 && b2<=21 && d<p1 && d<b1 && d<b2){
        return Action.HIT;
      }
      else {
        return Action.HOLD;
      }
    }
  

    

	

	@Override
	/**
	 * do not touch this method
	 */
	public int makeABet() {
		// the Dealer doesn't bet so is always zero
		return 0;
	}
}
