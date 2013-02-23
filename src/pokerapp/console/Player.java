package pokerapp.console;

import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class Player {
  private Hand hand = new Hand();

  public Player() {}

  public Hand getHand() { return hand; }

  public abstract void playTurn(IConsole console, Deck deck);



}
