package pokerapp.console;

import lombok.Getter;
import lombok.Setter;
import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Hand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 *
 * @author Steve
 * @author Ari
 *
 */
public abstract class Player {
  @Getter private Hand hand = new Hand();

  @Getter @Setter private String playerName = "";

  public Player() {}

  @Override
  public String toString(){
    return getPlayerName();
  }

  public abstract void playTurn(IConsole console, Deck deck);

  public void receiveCard(Card card) {
    hand.add(card);
  }
}
