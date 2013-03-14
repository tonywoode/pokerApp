package pokerapp.console;

import pokerapp.console.strategies.IStrategy;
import pokerapp.console.strategies.IStrategyFactory;
import pokerapp.console.strategies.StandardStrategyFactory;

/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
 * @param //TODO:Parameter Description
 */
public class StandardComputerPlayer extends ComputerPlayer {

    public StandardComputerPlayer(String name){
        setPlayerName(name);
    }

    public StandardComputerPlayer() {
        this("");
        setDifficultyCode("S");
    }

    @Override
    protected String exchangeDecision(StringBuilder commandBuilder, String handType)
    {
        IStrategyFactory strategyFactory = new StandardStrategyFactory();

        IStrategy decisionMaker =  strategyFactory.createStrategy(handType);

        return decisionMaker.makeDecision(commandBuilder, getHand().getSortedCards());
    }

}
