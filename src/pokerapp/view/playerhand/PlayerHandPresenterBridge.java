package pokerapp.view.playerhand;

import pokerapp.Dealer;
import pokerapp.InteractivePlayer;
import pokerapp.Player;
import pokerapp.Players;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.scorer.PokerGameEvaluator;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import javax.swing.*;
import java.io.IOException;

/**
 * Bridge pattern for the display of the presenters hand.
 *
 * Uses the bridge because the presenter API was very
 * unstable when first introduced.
 *
 * @author steve
 *
 */
public class PlayerHandPresenterBridge {

  private final PlayerHandPresenter handPresenter;
  private final Dealer dealer;
  private Player player;

  public PlayerHandPresenterBridge(PlayerHandPresenter phPresenter, Dealer dealer) {
    handPresenter = phPresenter;
    this.dealer = dealer;
  }

  public void playRandomHand() throws FormatStringException, IOException, IllegalFormatCodeException {
    InteractivePlayer ip = new InteractivePlayer();
    Players players = new Players(PokerGameEvaluator.create()).register(ip);

    dealer.dealCards(5, players);
    handPresenter.init(ip, ip.getHand());
  }

  public JComponent getView() {
    return handPresenter.getView();
  }

  public void setPlayer(Player player) throws FormatStringException, IOException,
      IllegalFormatCodeException {
    this.player = player;
    handPresenter.init(player, player.getHand());
  }

  public Player getPlayer() {
    return player;
  }
}
