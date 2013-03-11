package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * @author ari
 * Date: 11/03/2013
 * Time: 01:55
 * Created with IntelliJ IDEA.
 */
public class EasyComputerPlayer extends ComputerPlayer {

  public EasyComputerPlayer(String name){
    setPlayerName(name);
  }

  public EasyComputerPlayer() {
    this("");
  }

  @Override
  public void playTurn(IConsole console, Deck deck){

    StringBuilder commandBuilder = new StringBuilder();
    ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
    String handType = scoredHand.getName();
    console.writeMessage(getPlayerName() + " (E) has: " + getHand().toFancyUserString() + handType);


    int targetRank = 8;  //easy player discards cards with rank > targetRank

    int n = 0;
    for(Card card: getHand()) {
      n++;
      if ( card.getRank() > targetRank && commandBuilder.length() < 6 )
            commandBuilder.append(n).append(" ");
    }

    String command = commandBuilder.toString();
    ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
    interpreter.execute(getHand(), deck);
    console.writeMessage(getPlayerName() + " (E) exchanged " + command);

    scoredHand = new HandScorerBuilder().create().score(getHand());
    handType = scoredHand.getName();
    console.writeMessage(getPlayerName() + " (E) has: " + getHand().toFancyUserString() + handType);

  }

}
