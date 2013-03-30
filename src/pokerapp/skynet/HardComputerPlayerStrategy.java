package pokerapp.skynet;

import lombok.Setter;
import pokerapp.Card;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.Player;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @author Sam
 * @version 1
 */
public class HardComputerPlayerStrategy extends ComputerPlayerStrategy implements HandVisitor {

    private LogicBridge logic;
    private Dealer dealer;
    @Setter
    private int numOfCardsThatCanBeExchanged = 3;

    @Override
    public void setPlayer(Player player)
    {
        setPlayer(player);
        logic = new HardLogic(getPlayer());
    }


    @Override
    public void playTurn(Dealer dealer, ScoredHand handType) {
    handType.visit(this);
    this.dealer = dealer;
  }

  @Override
  public void accept(ScoredHand sh, Flush flush) {
        return;
  }

  @Override
  public void accept(ScoredHand sh, FullHouse fullhouse) {
     return;
  }

  @Override
  public void accept(ScoredHand sh, NoPair noPair) {
      ArrayList<Card> posExchange = new ArrayList<Card>();
      if(logic.hasOtherPlayerMoved())
     {
         posExchange = logic.getNearFlushRemoval(1);
         if(posExchange != null)
         {
             for(int i = 0; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
             {
               dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
             }
         }
         else{
             posExchange =  logic.getNearStraightRemoval(1);
             if(posExchange != null){
                 for(int i =0 ; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
                 {
                     dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                 }
             }
         }
     }
     else{
         posExchange = getPlayer().getHand().getSortedCards();
         Collections.reverse(posExchange);
         for(int i =0 ; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
          {
              dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
          }
     }

  }

  @Override
  public void accept(ScoredHand sh, Run run) {
      if(logic.hasOtherPlayerMoved())
      {
          ArrayList<Card> posExchange = new ArrayList<Card>();
          if(logic.hasOtherPlayerMoved())
          {
              posExchange = logic.getNearFlushRemoval(1);
              if(posExchange != null)
              {
                  for(int i = 0; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
                  {
                      dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                  }
              }
              else{
                  posExchange =  logic.getNearStraightRemoval(1);
                  if(posExchange != null){
                      for(int i =0 ; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
                      {
                          dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                      }
                  }
              }
          }
          else
          {
              posExchange = (ArrayList<Card>) sh.getRelevantCards();
              ArrayList<Card> handToManip = sh.getHand().getSortedCards();
              for(int i =0 ; i <= handToManip.size() && i <= numOfCardsThatCanBeExchanged; i++)
              {
                  if(!handToManip.contains(posExchange.get(i)))
                  {
                      dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                  }
              }
          }
      }
}

  @Override
  public void accept(ScoredHand sh, RoyalFlush royalFlush) {
         return;
  }

  @Override
  public void accept(ScoredHand sh, Straight straight) {
      ArrayList<Card> posExchange = new ArrayList<Card>();
      if(logic.hasOtherPlayerMoved())
      {
          posExchange = logic.getNearFlushRemoval(1);
          if(posExchange != null)
          {
              for(int i = 0; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
              {
                  dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
              }
          }
      }
      else
        return;
}

  @Override
  public void accept(ScoredHand sh, StraightFlush straightFlush) {
      return;
  }

  @Override
  public void accept(ScoredHand sh, TwoPair twoPair) {
      if(logic.hasOtherPlayerMoved())
      {
          ArrayList<Card> posExchange = new ArrayList<Card>();
          if(logic.hasOtherPlayerMoved())
          {
              posExchange = logic.getNearFlushRemoval(1);
              if(posExchange != null)
              {
                  for(int i = 0; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
                  {
                      dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                  }
              }
              else{
                  posExchange =  logic.getNearStraightRemoval(1);
                  if(posExchange != null){
                      for(int i =0 ; i <= posExchange.size() && i <= numOfCardsThatCanBeExchanged; i++)
                      {
                          dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                      }
                  }
              }
          }
          {
              posExchange = (ArrayList<Card>) sh.getRelevantCards();
              ArrayList<Card> handToManip = sh.getHand().getSortedCards();
              for(int i =0 ; i <= handToManip.size() && i <= numOfCardsThatCanBeExchanged; i++)
              {
                  if(!handToManip.contains(posExchange.get(i)))
                  {
                      dealer.exchangeCard(getPlayer().getHand(), posExchange.get(i));
                  }
              }
          }
      }
  }

}
