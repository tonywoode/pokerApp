package pokerapp.view.pokergame;

import lombok.Getter;
import pokerapp.Dealer;
import pokerapp.console.ComputerPlayer;
import pokerapp.console.InteractivePlayer;
import pokerapp.console.Player;
import pokerapp.console.Players;

/**
 * Sets the basic parameters for a generic pokergame - players and dealer and setting a winner
 * @author Steve
 * @version 1
 */
public class PokerGameModel {
  private final Dealer dealer;
  @Getter
  private final InteractivePlayer interactivePlayer;
  @Getter
  private final ComputerPlayer computerPlayer;
  private final Players players;

  public PokerGameModel(Dealer dealer, InteractivePlayer interactivePlayer, ComputerPlayer computerPlayer,
                        Players players) {
    this.dealer = dealer;
    this.interactivePlayer = interactivePlayer;
    this.computerPlayer = computerPlayer;
    this.players = players;
    this.players.register(interactivePlayer, computerPlayer);
  }

  public Player pickWinner() {
    return players.pickWinner();
  }

  public void dealCards() {
    dealer.dealCards(5, players);
  }
}
