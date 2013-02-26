package pokerapp.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 26/02/13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class is intended to hold constants required elsewhere in the app and eradicate magic numbers.
 *
 * TODO:Probably better to have more than one class, each containing constants used by a group of classes performing a related function.
 *
 * In any case at least we get to use the Singleton (anti) pattern.
 *
 **/
public class Constants {

    private Constants() {}    //singleton

    public static final int MAX_SUITS = 4;
    public static final int MAX_RANKS = 14;
    public static int FULL_DECK = 5;         //We are implementing a 5-card poker variant
    public static int RANK_ACE_LO = 1;

    public static int LEN_CARD = 2;


    //1 = Clubs, 2 = Diamonds, 3 = Hearts, 4 = Spades
    //http://wiki.answers.com/Q/What_is_the_suit_order_in_a_deck_of_cards_for_poker

    public static int  POS_CLUB = 1;
    public static int POS_DIAMOND = 2;
    public static int POS_HEART = 3;
    public static int POS_SPADE = 4;

    public static char  CHAR_CLUB = 'C';
    public static char CHAR_DIAMOND = 'D';
    public static char CHAR_HEART = 'H';
    public static char CHAR_SPADE = 'S';

}


