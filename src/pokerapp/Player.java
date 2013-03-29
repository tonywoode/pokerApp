package pokerapp;

import lombok.Getter;
import lombok.Setter;
import pokerapp.console.ExchangeSetting;
import pokerapp.console.Console;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

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

  public abstract void playTurn(Console console, Deck deck, ExchangeSetting exchangeSetting) throws IOException, FormatStringException, IllegalFormatCodeException;

  public void receiveCard(Card card) {
    hand.add(card);
  }

  public void dropHand(){
   hand = new Hand();

  }


  public void receiveHand(Hand otherHand) {
    hand = otherHand;
  }
}
