package pokerapp;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 30/03/13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class HistoryTable {
    @Getter @Setter
    private boolean playerMoved;

    public HistoryTable()
    {
        playerMoved = true;
    }
}
