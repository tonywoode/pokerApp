package pokerapp.scorer.scorers;

import pokerapp.Hand;
import pokerapp.scorer.domain.Spares;
import pokerapp.scorer.scoredhands.NoPairScoredHand;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 09/03/13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class NoPairScorer extends HandScorer {
    @Override
    protected ScoredHand resolveCore(Hand hand) {
       return new NoPairScoredHand(getHandNumber(),hand, new Spares(hand));
    }
}
