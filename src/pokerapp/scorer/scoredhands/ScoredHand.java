package pokerapp.scorer.scoredhands;

import lombok.Getter;
import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.scorer.HandVisitor;
import pokerapp.scorer.typetag.HandType;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Provides an implementation of the notion of a hand that
 * has been scored. The various types of hands subclass
 * this and implement the getName() and compareEqualCategories()
 * methods, depending on the definition of that particular type
 * of hand.
 * 
 *@author steve
 */
public abstract class ScoredHand implements Comparable<ScoredHand> {

  @Getter protected HandType handType;
  @Getter protected int handNumber = -1;
  @Getter protected Hand hand;

	protected ScoredHand(int handNumber, Hand hand, HandType handType) {
		this.handNumber = handNumber;
		this.hand = hand;
    this.handType = handType;
	}

	/**
	 * Compares two hand categories, returns numerical result of the comparison.
	 * <p>
	 * Pattern: Template Method (GoF)
	 * @param rhs a hand category
	 * @return a number representing the comparison
	 */
	public int compareTo(ScoredHand rhs) {
		int c =  Integer.compare(handNumber, rhs.handNumber);
		if (c == 0)
			return compareEqualCategories(rhs);
		else
			return c;
	}

	/** All hands have a 'category' name. Most know their own name,
	 * but some must calculate. Hence an abstract property.
	 */
	public abstract String getName();

  public abstract Rank getHandRank();

	/** Called when two hands are in the same category. We need
	 * to determine which hand is better.
	 */ 
	protected abstract int compareEqualCategories(ScoredHand rhs);

    public abstract List<Card> getRelevantCards();


    public void visit(HandVisitor visitor) {
        handType.visit(this, visitor);
    }
}
