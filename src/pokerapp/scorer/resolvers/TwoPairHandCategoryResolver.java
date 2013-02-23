package pokerapp.scorer.resolvers;

import pokerapp.Hand;
import pokerapp.scorer.categories.HandCategory;
import pokerapp.scorer.categories.TwoPairHandCategory;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 01:53
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairHandCategoryResolver extends RankedHandCategoryResolver {
    public TwoPairHandCategoryResolver() {
        super("2pair", 2, 2);
    }

    @Override
    protected HandCategory createHandCategory(Hand hand){
       return new TwoPairHandCategory("2pair", this.number, hand);
    }
}
