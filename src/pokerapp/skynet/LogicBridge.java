package pokerapp.skynet;

import pokerapp.Card;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 30/03/13
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public interface LogicBridge {
    final int HANDSIZE = 5;

    public   ArrayList<Card> getNearStraightRemoval(int index);

    public   ArrayList<Card> getNearFlushRemoval (int index);

    public Boolean hasOtherPlayerMoved();
}
