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
      protected String exchangeDecision(StringBuilder commandBuilder,String handType)
      {
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

          return commandBuilder.toString();
      }

}

