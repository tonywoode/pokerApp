package pokerapp.console;

import lombok.Setter;
import pokerapp.Card;
import pokerapp.Deck;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class ComputerPlayer extends Player {

    @Setter int targetRank;

    public ComputerPlayer(String name){
        setPlayerName(name);

    }

    public ComputerPlayer(){
        this("Computer");
    }

    public void playTurn(IConsole console, Deck deck){

        StringBuilder commandBuilder = new StringBuilder();
        ScoredHand scoredHand = new HandScorerBuilder().create().score(getHand());
        String handType = scoredHand.getName();
        console.writeMessage(getPlayerName() + " (E) has: " + getHand().toFancyUserString() + handType);
        
        String command = exchangeDecision(commandBuilder, handType);
        ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
        interpreter.execute(getHand(), deck);
        console.writeMessage(getPlayerName() + " (E) exchanged " + command);

        scoredHand = new HandScorerBuilder().create().score(getHand());
        handType = scoredHand.getName();
        console.writeMessage(getPlayerName() + " (E) has: " + getHand().toFancyUserString() + handType);

    }

    protected abstract String exchangeDecision(StringBuilder commandBuilder, String handType);


    //@Override
    // extract common bits of public void playTurn(IConsole console, Deck deck){

}
