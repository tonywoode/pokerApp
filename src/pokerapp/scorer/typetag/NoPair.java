package pokerapp.scorer.typetag;

import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 20/03/13
 * Time: 22:46
 * To change this template use File | Settings | File Templates.
 */
public class NoPair extends HandTypeTag {
    public NoPair(){}

    @Override
    public void visit(ScoredHand sh, HandVisitor visitor) {
        visitor.accept(sh, this);
    }

}
