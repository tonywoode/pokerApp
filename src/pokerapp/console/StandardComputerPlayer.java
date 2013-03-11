package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
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

    public StandardComputerPlayer(String name){
        setPlayerName(name);
    }

    public StandardComputerPlayer() {
        this("");
    }

    @Override
    protected String exchangeDecision(StringBuilder commandBuilder, String handType)
    {
        return null;
    }

}
