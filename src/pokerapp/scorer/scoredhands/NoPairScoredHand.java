package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 09/03/13
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class NoPairScoredHand extends AbstractScoredHand<NoPairScoredHand> {

    @Getter private Spares spares;

    public NoPairScoredHand(int handNumber, Hand hand, Spares spares) {
        super(handNumber, hand);
        this.spares = spares;
    }

    @Override
    protected int compareEqualCategories(NoPairScoredHand rhs) {
        return Comparator
                .begin(spares, rhs.spares)
                .compare();
    }

    /**
     * All hands have a 'category' name. Most know their own name,
     * but some must calculate. Hence an abstract property.
     */
    @Override
    public String getName() {
        return "No pair";
    }

    @Override
    public List<Card> getRelevantCards() {
        return new ArrayList<Card>();
    }
}
