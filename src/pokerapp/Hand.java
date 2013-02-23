package pokerapp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 00:56
 * To change this template use File | Settings | File Templates.
 */



public class Hand implements Iterable<Card> {
  ArrayList<Card> cards = new ArrayList<Card>();

  // TODO: decide whether this belongs here.
  //       Used by many HandCategoryScorers, so held here for convenience...
  HandRankHistogram rankHistogram = null;

  static final int MAX_CARDS = 5;

  public void add(Card card) throws Exception {
    if (cards.size() >= MAX_CARDS)
      throw new Exception("Hand is full");

    cards.add(card);
  }

  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  public HandRankHistogram getRankHistogram() {
    if (rankHistogram == null)
      rankHistogram = new HandRankHistogram(this);
    return rankHistogram;
  }

  public ArrayList<Card> getSortedCards() {
    ArrayList<Card> sortedCards = (ArrayList<Card>)cards.clone();

    Collections.sort(sortedCards, new HighLowCardComparator());

    return sortedCards;
  }

  public String toUserString() {
    String msg = "";

    for (Card card : cards)
      msg += card.toString() + " "; // TODO: additional space at end...

    return msg;
  }

  public Card exchange(int pos, Card card) {
    return cards.set(pos, card);
  }
}
