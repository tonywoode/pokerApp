package pokerapp.scorer;

import pokerapp.scorer.categories.RankedHandCategory;
import pokerapp.scorer.resolvers.*;

import java.util.ArrayList;

/**
 * Builds the categories of scoring hands and returns the ordered list of them
 * User: steve
 * Date: 22/02/13
 * Time: 01:55
 * To change this template use File | Settings | File Templates.
 */
public class HandCategoryResolverBuilder {

  public HandCategoryResolver create() {
    ArrayList<HandCategoryResolver> resolvers = new ArrayList<HandCategoryResolver>();

    resolvers.add(new RankedHandCategoryResolver("four", 4));
    resolvers.add(new FlushHandCategoryResolver());
    resolvers.add(new StraightHandCategoryResolver());
    resolvers.add(new RankedHandCategoryResolver("three", 3));
    resolvers.add(new RankedHandCategoryResolver("2pair", 2, 2));
    resolvers.add(new RankedHandCategoryResolver("pair", 2));
    resolvers.add(new HighCardCategoryResolver());
    resolvers.add(null);

    for (int iter = 0; iter < resolvers.size() - 1; ++iter) {
      resolvers.get(iter).setNextScorer(resolvers.get(iter + 1));
      resolvers.get(iter).setCategoryNumber(resolvers.size() - iter);
    }

    return resolvers.get(0);
  }

}
