package pokerapp.skynet;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Player;
import pokerapp.scorer.HandRanks;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

import java.util.ArrayList;
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
 * @version 1
 */
public class HardComputerPlayerStrategy extends ComputerPlayerStrategy implements HandVisitor {

    private LogicBridge logic;

    @Override
    public void setPlayer(Player player)
    {
        setPlayer(player);
        logic = new HardLogic(getPlayer());
    }


    @Override
  public void playTurn(ScoredHand handType) {
    handType.visit(this);
  }

  @Override
  public void accept(ScoredHand sh, Flush flush) {

  }

  @Override
  public void accept(ScoredHand sh, FullHouse fullhouse) {
    
  }

  @Override
  public void accept(ScoredHand sh, NoPair noPair) {
    
  }

  @Override
  public void accept(ScoredHand sh, Run run) {
    
  }

  @Override
  public void accept(ScoredHand sh, RoyalFlush royalFlush) {
    
  }

  @Override
  public void accept(ScoredHand sh, Straight straight) {
    
  }

  @Override
  public void accept(ScoredHand sh, StraightFlush straightFlush) {
    
  }

  @Override
  public void accept(ScoredHand sh, TwoPair twoPair) {
    
  }

}
