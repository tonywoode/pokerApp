package pokerapp.console.jcommandergame;

import pokerapp.Dealer;
import pokerapp.InteractivePlayer;
import pokerapp.Player;
import pokerapp.Players;

/**
 * Created by Tony on 10/05/14.
 */
public class PokerCommanderGame {
    private Dealer dealer;
    private Players players;

    private int numTurns;
    private int numExchanges;

    public void registerPlayer(Player player) {
        players.register(player);
    }
}
