package pokerapp.console;

import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.HandTypeTag;

/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 */
public class StandardComputerPlayer extends ComputerPlayer {

    public StandardComputerPlayer(String name){
        setPlayerName(name);
    }

    public StandardComputerPlayer() {
        this("");
    }

    @Override
    protected void exchangeDecision(ScoredHand handType)
    {
       handType.visit(new StandardStrategyVisitor());
    }

}
