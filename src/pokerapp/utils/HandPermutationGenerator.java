package pokerapp.utils;

import pokerapp.Hand;
import pokerapp.Card;
import pokerapp.HandFactory;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 24/02/13
 * Time: 12:26
 * Built with the aid of http://stackoverflow.com/a/14444037
 */

public class HandPermutationGenerator {

    static final int START_INDEX = 0;
    static final int MAX_INDEX = 4;

    public static ArrayList<Hand> permute(Hand hand) {
        HandFactory newHandFactory = new HandFactory();
        return permutator(hand, START_INDEX, new HandFactory());
    }

    private static ArrayList<Hand> permutator(Hand hand, int index, HandFactory newHandFactory) {

        ArrayList<Hand> returnArray = new ArrayList<Hand>();
        ArrayList<Card> cards = hand.getCards();
        int numCards = cards.size();
        try {

            if(index == MAX_INDEX)
            {
                returnArray.add(hand);

                return returnArray;
            }

            if (cards.size() > 5)
                throw new ArrayIndexOutOfBoundsException();


            for (int i = index; i < numCards; i++) {
                java.util.Collections.swap(cards, i, index);
                String[] cardsString = new String[5];
                int j = 0;
                for (Card card : cards) {
                    cardsString[j++] = card.toString();
                }
                for (Hand returnedHands : permutator(newHandFactory.create(cardsString), index + 1, newHandFactory))
                    returnArray.add(returnedHands);
                java.util.Collections.swap(cards, index, i);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("To many cards!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnArray;
    }
}
