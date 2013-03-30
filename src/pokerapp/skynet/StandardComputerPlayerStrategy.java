package pokerapp.skynet;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.scoredhands.SameRankScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.scoredhands.StraightFlushScoredHand;
import pokerapp.scorer.scoredhands.TwoPairScoredHand;
import pokerapp.scorer.typetag.*;

import pokerapp.Card;

/**
 * <p>
 *   Implements reasonably non-idiotic computer player behaviour.
 *   Essentially, if the CP has a NoPair, it delegates to the
 *   EasyStrategy (which randomly exchanges cards).
 *
 *   However, if the CP has a scoring hand, the kickers, with
 *   a rank less than Jack (i.e., not a face card), are exchanged
 *   in the somewhat optimisic belief that a better hand may arise.
 * </p>
 *
 * @author Steve
 * @version 1
 */
@RequiredArgsConstructor
public class StandardComputerPlayerStrategy extends ComputerPlayerStrategy implements HandVisitor {
  private Dealer dealer;
  private final EasyComputerPlayerStrategy easyStrategy;

  @Override
  public ComputerPlayerStrategy createNew() {
    return new StandardComputerPlayerStrategy((EasyComputerPlayerStrategy)easyStrategy.createNew());
  }

  @Override
  public String toString() {
    return "Hot";
  }

  @Override
  public void playTurn(Dealer dealer, ScoredHand handType) {
    this.dealer = dealer;
    handType.visit(this);
  }

  @Override
  public void accept(ScoredHand sh, NoPair noPair) {
    easyStrategy.playTurn(dealer, sh);
  }

  @Override
  public void accept(ScoredHand sh, Flush flush) {
    // no kickers... no move...
  }

  @Override
  public void accept(ScoredHand sh, FullHouse fullhouse) {
    // no kickers... no move...
  }

  @Override
  public void accept(ScoredHand sh, SameRank sameRank) {
    playTurnBasedOnGoodHand(dealer, sh, ((SameRankScoredHand) sh).getSpares());
  }

  @Override
  public void accept(ScoredHand sh, RoyalFlush royalFlush) {
    // no kickers... no move
  }

  @Override
  public void accept(ScoredHand sh, Straight straight) {
    // no kickers... no move
  }

  @Override
  public void accept(ScoredHand sh, StraightFlush straightFlush) {
    // no kickers... no move
  }

  @Override
  public void accept(ScoredHand sh, TwoPair twoPair) {
    playTurnBasedOnGoodHand(dealer, sh, ((TwoPairScoredHand)sh).getSpares());
  }

  private void playTurnBasedOnGoodHand(Dealer dealer, ScoredHand sh, Spares kickers) {
    for (Card card : kickers.getKickers())
        if (Rank.JACK.beats(card.getRank()))
          dealer.exchangeCard(sh.getHand(), card);
  }
}
