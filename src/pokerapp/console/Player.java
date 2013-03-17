package pokerapp.console;

import lombok.Getter;
import lombok.Setter;
import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Hand;

/**
 * @author Steve
 * @author Ari
 * @version 1.0
 */
public abstract class Player {
  @Getter private Hand hand = new Hand();

  @Getter @Setter private String playerName = "";

  public Player() {}

  @Override
  public String toString(){
    return getPlayerName();
  }

  public abstract void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting);

  public void receiveCard(Card card) {
    hand.add(card);
  }
}
