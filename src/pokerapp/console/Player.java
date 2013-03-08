package pokerapp.console;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class Player {
  @Getter private Hand hand = new Hand();

  public Player() {}

  public abstract void playTurn(IConsole console, Deck deck);


  public void receiveCard(Card card) {
    hand.add(card);
  }
}
