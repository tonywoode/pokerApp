package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.ArrayList;

/**
 * @author ari
 * Date: 11/03/2013
 * Time: 03:49
 * Created with IntelliJ IDEA.
 */
public class HardComputerPlayer extends ComputerPlayer {

  public HardComputerPlayer(String name){
    setPlayerName(name);
  }

  public HardComputerPlayer() {
    this("");
  }

  @Override
  public void playTurn(IConsole console, Deck deck) {

    StringBuilder commandBuilder = new StringBuilder();
    ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
    String handType = scoredHand.getName();
    console.writeMessage(getPlayerName() + " (H) has: " + getHand().toFancyUserString() + handType);

    if ("No pair".equals(handType)) {     //hard player swaps lowest three cards if no pair


      ArrayList<Card> sortedCards = getHand().getSortedCards();

      int targetRank = sortedCards.get(3).getRank();

      int n = 0;
      for(Card card: getHand()) {
        n++;
        if ( card.getRank() <= targetRank && commandBuilder.length() < 6 )
          commandBuilder.append(n).append(" ");
      }
    }
//    else {
//
//      if ("Pair".equals(handType)) {
//
//    }
    //TODO: Chain of Resp here?

    String command = commandBuilder.toString();
    if(command.isEmpty()) {

      console.writeMessage(getPlayerName() + " (H) sticks: " + getHand().toFancyUserString() + handType);
      console.writeMessage("Still has: " + getHand().toFancyUserString());

    }  else {

      ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
      interpreter.execute(getHand(), deck);
      console.writeMessage(getPlayerName() + " (H) exchanged " + command);

      console.writeMessage("New hand is: " + getHand().toFancyUserString());
      scoredHand = new HandScorerBuilder().create().score(getHand());
      handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (H) has: " + getHand().toFancyUserString() + handType);
    }

  }

}

