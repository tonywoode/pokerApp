package pokerapp.view.pokergame;

import lombok.Getter;
import pokerapp.*;

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

  /**
   * Getter for winner
   * @return player that won the round
   */
  public Player pickWinner() {
    return null; // TODO: who uses this?
  }

  /**
   * Getter for the dealer dishing out a hand
   */
  public void dealCards() {
    dealer.dealCards(5, players);
  }
}
