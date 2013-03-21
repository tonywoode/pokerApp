package pokerapp.console;

import pokerapp.console.strategies.HardStrategyFactory;
import pokerapp.console.strategies.IStrategy;
import pokerapp.console.strategies.IStrategyFactory;

/**
 * @author Steve
 * @author Ari
 * @author Sam
 * @version 1.0
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
          IStrategyFactory strategyFactory = new HardStrategyFactory();

          IStrategy decisionMaker =  strategyFactory.createStrategy(handType);

          return decisionMaker.makeDecision(commandBuilder, getHand().getSortedCards());
   /*
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
//   }
          //TODO: Strategy pattern will work here

          return commandBuilder.toString();
        */
      }}

