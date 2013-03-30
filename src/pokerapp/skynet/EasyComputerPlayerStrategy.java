package pokerapp.skynet;

import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

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
public class EasyComputerPlayerStrategy extends ComputerPlayerStrategy implements HandVisitor {

  @Override
  public void playTurn(ScoredHand handType) {
    handType.visit(this);
  }

  @Override
  public ComputerPlayerStrategy createNew() {
    return new EasyComputerPlayerStrategy();
  }

  @Override
  public String toString() {
    return "Easy";
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
