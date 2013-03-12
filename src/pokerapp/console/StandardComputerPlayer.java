package pokerapp.console;

import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.console.strategies.HardStrategyFactory;
import pokerapp.console.strategies.IStrategy;
import pokerapp.console.strategies.IStrategyFactory;
import pokerapp.console.strategies.StandardStrategyFactory;
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
        IStrategyFactory strategyFactory = new StandardStrategyFactory();

        IStrategy decisionMaker =  strategyFactory.createStrategy(handType);

        return decisionMaker.makeDecision(commandBuilder, getHand().getSortedCards());
    }

}
