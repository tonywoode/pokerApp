package pokerapp.skynet;

import pokerapp.ComputerPlayer;

import java.util.HashMap;
import java.util.List;

/**
 * @author Steve
 * @author Ari
 * @version 1.1
 */
public class NamedComputerPlayerFactory {
  private final HashMap<String, ComputerPlayer> players = new HashMap<>();
  private final List<ComputerPlayer> playersByIndex;

  public NamedComputerPlayerFactory(List<ComputerPlayer> players) {
    this.playersByIndex = players;
    for (ComputerPlayer player : players)
      this.players.put(player.getPlayerName(), player);
  }

  public ComputerPlayer create(String name) {
    return players.get(name).createNew();
  }

  public ComputerPlayer create(int index){
    return playersByIndex.get(index).createNew();
  }

  public Iterable<ComputerPlayer> getPlayers() {
    return playersByIndex;
  }
}


