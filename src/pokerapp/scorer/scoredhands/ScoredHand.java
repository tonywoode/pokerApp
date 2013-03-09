package pokerapp.scorer.scoredhands;

import pokerapp.Hand;

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

	private int handNumber = -1;
	protected Hand hand;

	protected ScoredHand(int handNumber, Hand hand) {
		this.handNumber = handNumber;
		this.hand = hand;
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

	/** Called when two hands are in the same category. We need
	 * to determine which hand is better.
	 */ 
	protected abstract int compareEqualCategories(ScoredHand rhs);
}
