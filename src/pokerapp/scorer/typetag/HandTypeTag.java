package pokerapp.scorer.typetag;

import pokerapp.console.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 20/03/13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class HandTypeTag {
    public abstract void visit(ScoredHand sh, HandVisitor visitor);
}
