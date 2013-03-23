package pokerapp.console;

import pokerapp.scorer.scoredhands.ScoredHand;
import pokerapp.scorer.typetag.*;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 22/03/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class StandardStrategyVisitor implements HandVisitor {
    @Override
    public void accept(ScoredHand sh, Flush flush) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, FullHouse fullhouse) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, NoPair noPair) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, Run run) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, RoyalFlush royalFlush) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, Straight straight) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, StraightFlush straightFlush) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void accept(ScoredHand sh, TwoPair twoPair) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
