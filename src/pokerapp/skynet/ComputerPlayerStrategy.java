package pokerapp.skynet;



import lombok.Getter;
import lombok.Setter;
import pokerapp.Dealer;
import pokerapp.Player;
import pokerapp.scorer.scoredhands.ScoredHand;

/**
 *
 * @author Steve
 * @version 1
 */
public abstract class ComputerPlayerStrategy {
  public abstract void playTurn(Dealer dealer, ScoredHand handType);

  /**
   * Implements the prototype pattern
   *
   * @return a clone of the strategy
   */
  public abstract ComputerPlayerStrategy createNew();

  @Getter @Setter
  private Player player;


}
