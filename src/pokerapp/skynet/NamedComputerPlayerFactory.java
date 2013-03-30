package pokerapp.skynet;

import pokerapp.ComputerPlayer;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ari
 * @author Steve
 * @version 1.1
 */
public class NamedComputerPlayerFactory {
  private final HashMap<String, ComputerPlayer> players = new HashMap<>();

  public NamedComputerPlayerFactory(List<ComputerPlayer> players) {
    for (ComputerPlayer player : players)
      this.players.put(player.getPlayerName(), player);
  }

  public ComputerPlayer create(String name) {
    return players.get(name).createNew();
  }

  public Iterable<ComputerPlayer> getPlayers() {
    return players.values();
  }
}


