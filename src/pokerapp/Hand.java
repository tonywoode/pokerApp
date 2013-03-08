package pokerapp;


import pokerapp.scorer.domain.Spares;
import pokerapp.utils.Constants;

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

  /**
   * Adds a card to a hand
   * @param card a card
   * @throws IndexOutOfBoundsException
   */
  public void add(Card card) throws IndexOutOfBoundsException {
    if (cards.size() >= Constants.HAND_SIZE)
      throw new IndexOutOfBoundsException("Hand is full");

    cards.add(card);
  }

  /**
   * presents the cards from the hand
   * @return individual cards from the hand
   */
  public Iterator<Card> iterator() {
    return cards.iterator();
  }

  /**
   * sorts a hand of cards and returns on sorted order
   * @return sorted list of cards
   */
  public ArrayList<Card> getSortedCards() {
    ArrayList<Card> sortedCards = (ArrayList<Card>)cards.clone();

    Collections.sort(sortedCards, new HighToLowCardComparator());

    return sortedCards;
  }

    /**
     * returns each card as an unsorted array
     * @return array of cards in the hand
     *
     */

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * returns each card as text separated by whitespace
     * @return text representation of the hand
     *
     */

    public String toUserString() {

    StringBuffer msg = new StringBuffer();

    for (Card card : cards){
      msg.append(card.toString());
      msg.append(" ");
    }

    return msg.toString();
  }

  /**
   * exchanges an individual card in a position in the hand with another
   * @param pos position of card to be removed
   * @param card the card to replace with
   * @return the hand after cards have been exchanged
   */
  public Card exchange(int pos, Card card) {
    return cards.set(pos, card);
  }

  // TODO: This package reference is invalid. Should not deleve down there...
  // TODO: The implementation is poor; lack the time to do it better...
  public Spares getKickers(int... keepRanks) {
    ArrayList<Card> spareCards = new ArrayList<Card>();

    for (Card card : cards) {
      boolean isNotKicker = false;
      for (int rank : keepRanks) {
        if (card.getRank() == rank)
          isNotKicker = true;
      }
      if (!isNotKicker)
        spareCards.add(card);
    }

    return new Spares(spareCards);
  }

  // These don't belong here...
  public Iterable<Card> cardsOfRank(int... ranks) {
    ArrayList<Card> cardsSubset = new ArrayList<Card>();
    for (Card card : cards)
      for (int rank : ranks)
        if (card.getRank() == rank)
          cardsSubset.add(card);
    return cardsSubset;
  }

  public Iterable<Card> cardsNotOfRank(int rank) {
    ArrayList<Card> cardsSubset = new ArrayList<Card>();
    for (Card card : cards)
      if (card.getRank() != rank)
        cardsSubset.add(card);
    return cardsSubset;
  }
}
