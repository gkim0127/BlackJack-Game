package nz.ac.auckland.softeng281.a2;

import java.util.Random;

/**
 * you should change this class for TASK 1
 */
public class BotPlayer extends Participant {

	public BotPlayer(String name) {
		super(name);
	}

	@Override
	public Action decideAction() {
		// TODO
    if (getCurrentHand().getScore()<17){
		return Action.HIT;
    }
    else  { 
      return Action.HOLD;
    } // FIXME  
	}

	@Override
	public int makeABet() {
		int r=(int) (Math.random()*99)+1;
		return r; // FIXME
	}
}
