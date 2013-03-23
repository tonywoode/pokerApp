package pokerapp.view.pokergame;

import lombok.Getter;
import pokerapp.Dealer;
import pokerapp.Players;
import pokerapp.ComputerPlayer;
import pokerapp.InteractivePlayer;
import pokerapp.Player;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
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
