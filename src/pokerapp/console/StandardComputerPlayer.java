package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve & Ari
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class StandardComputerPlayer extends ComputerPlayer {


  public StandardComputerPlayer(String name){
    setPlayerName(name);
  }

  public StandardComputerPlayer() {
    this("");
  }

  @Override
  public void playTurn(IConsole console, Deck deck) {
  //take common func out to the base
    StringBuilder commandBuilder = new StringBuilder();
    ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
    String handType = scoredHand.getName();
    console.writeMessage(getPlayerName() + " (S) has: " + getHand().toFancyUserString() + handType);

    if("No pair".equals(handType)){     //standard player swaps cards < targetRank if hand is No pair
      int targetRank = 10;

      int n = 0;
      for(Card card: getHand()) {
         n++;
         if ( card.getRank() < targetRank && commandBuilder.length() < 6 )
            commandBuilder.append(n).append(" ");
      }
    } //else if pair swap the spares etc


    String command = commandBuilder.toString();
    if(command.isEmpty())
      console.writeMessage(getPlayerName() + " (S) sticks: " + getHand().toFancyUserString() + handType);
    else {

      ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
      interpreter.execute(getHand(), deck);
      console.writeMessage(getPlayerName() + " (S) exchanged " + command);

      console.writeMessage("New hand is: " + getHand().toFancyUserString());
      scoredHand = new HandScorerBuilder().create().score(getHand());
      handType = scoredHand.getName();
      console.writeMessage(getPlayerName() + " (S) has: " + getHand().toFancyUserString() + handType);

    }
  }

}
