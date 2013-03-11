package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.Rank;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.scoredhands.ScoredHand;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class StandardComputerPlayer extends ComputerPlayer {

  @Override
  public void playTurn(IConsole console, Deck deck) {
      ScoredHand scoredHand =  new HandScorerBuilder().create().score(getHand());

      Spares kickers =  getHand().getKickers();

  }

}
