package pokerapp.console;

import lombok.Setter;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;


/**
 * @author   Steve
 * @author   Ari
 * @author   Sam
 * @version  1.0
 * @param    //TODO:Parameter Description
 */

public abstract class ComputerPlayer extends Player {

    @Setter int targetRank;
    @Setter private String difficultyCode = "";

    public ComputerPlayer(String name){
        setPlayerName(name);

    }

    public ComputerPlayer(){
        this("Computer");
    }

    public void playTurn(IConsole console, Deck deck, ExchangeSetting exchangeSetting){

      for(int numberExchanges = 0; numberExchanges < exchangeSetting.getNumTimes(); ++numberExchanges) {

        StringBuilder commandBuilder = new StringBuilder();
        ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
        String handType = scoredHand.getName();
        console.writeMessage(getPlayerName() + " (" + difficultyCode + ") has: " + getHand().toFancyUserString() + handType);
        
        String command = exchangeDecision(commandBuilder, handType);
        ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
        interpreter.execute(getHand(), deck);
        console.writeMessage(getPlayerName() + " (" + difficultyCode + ") exchanged " + command);

        scoredHand = new HandScorerBuilder().create().score(getHand());
        handType = scoredHand.getName();
        console.writeMessage(getPlayerName() + " (" + difficultyCode + ") has: " + getHand().toFancyUserString() + handType);

      }
    }

    protected abstract String exchangeDecision(StringBuilder commandBuilder, String handType);


    //@Override
    // extract common bits of public void playTurn(IConsole console, Deck deck){

}
