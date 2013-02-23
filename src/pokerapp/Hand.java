package pokerapp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Creates hands from cards and allows ranking, sorting, exchanging and printing of those hands
 * @author steve
 * @version 1.0
 */


public class Hand implements Iterable<Card> {
  ArrayList<Card> cards = new ArrayList<Card>();

  // TODO: decide whether this belongs here.
  //       Used by many HandCategoryScorers, so held here for convenience...
  HandRankHistogram rankHistogram = null;

  static final int MAX_CARDS = 5; //We are implementing a 5-card poker variant

  /**
   * Adds a card to a hand
   * @param card a card
   * @throws IndexOutOfBoundsException
   */
  public void add(Card card) throws IndexOutOfBoundsException {
    if (cards.size() >= MAX_CARDS)
      throw new IndexOutOfBoundsException("Hand is full");

    cards.add(card);
  }

  /**
   * TODO: THIS FREAKS ME OUT: HOW CAN THE PARENT CLASS IMPLEMENT ONE OF ITS OWN METHODS - YOURE SUPPOSED TO IMPLEMENT AN INTERFACE? Pls explain TW
   */
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  /**
   * hands are ranked according to a histogram lookup - a hand can return its own "worth"
   * @return the historgram representing the strength of this hand
   * @see TODO: where is the histogram code - need to link to it here?
   */
  public HandRankHistogram getRankHistogram() {
    if (rankHistogram == null)
      rankHistogram = new HandRankHistogram(this);
    return rankHistogram;
  }

  /**
   * sorts a hand of cards and returns on sorted order
   * @return sorted list of cards
   */
  public ArrayList<Card> getSortedCards() {
    ArrayList<Card> sortedCards = (ArrayList<Card>)cards.clone();

    Collections.sort(sortedCards, new HighLowCardComparator());

    return sortedCards;
  }

  /**
   * returns each card as text separated by whitespace
   * @return text representation of the hand
   *
   */
  //TODO: WHY IS THIS NOT JUST A TOSTRING?
  public String toUserString() {
    String msg = "";

    for (Card card : cards)
      msg += card.toString() + " "; // TODO: additional space at end...//TODO: why? TW

    return msg;
  }

  /**
   * exchanges an individual card in a position in the hand with another
   * @param pos postion of card to be removed
   * @param card the card to replace with
   * @return the hand after cards have been exchanged
   */
  public Card exchange(int pos, Card card) {
    return cards.set(pos, card);
  }
}
