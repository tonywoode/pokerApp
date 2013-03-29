package pokerapp.scorer;

import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

public interface HandVisitor {
  void accept(ScoredHand sh, Flush flush);
  void accept(ScoredHand sh, FullHouse fullhouse);
  void accept(ScoredHand sh, NoPair noPair);
  void accept(ScoredHand sh, Run run);
  void accept(ScoredHand sh, RoyalFlush royalFlush);
  void accept(ScoredHand sh, Straight straight);
  void accept(ScoredHand sh, StraightFlush straightFlush);
  void accept(ScoredHand sh, TwoPair twoPair);
}
