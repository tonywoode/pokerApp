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

    public static final int MIN_RANK = 1;
    public static final int MAX_RANK = 14;

}


