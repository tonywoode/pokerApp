package pokerapp;

import pokerapp.utils.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 28/02/13
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */
public class HandMatrix {

    private Hand hand;
    public int [][] matrix = new int[Constants.MAX_RANKS][Constants.MAX_SUITS+1];

    public HandMatrix(Hand other_hand){
        this.hand = other_hand;
        for(Card c: hand)
            matrix[c.getRank()][c.getSuit().getNumber()]++;
    }

    //TODO: create Rank & Flush Histograms here?

}
