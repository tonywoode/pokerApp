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

  public static final int DECK_SIZE = 52;
    public static final int RANK_ACE_LO = 1;

  public static final String[] RANK_NAME =
    {"", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

  public static final String[] RANK_SYMBOL =
      {"", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};



}


