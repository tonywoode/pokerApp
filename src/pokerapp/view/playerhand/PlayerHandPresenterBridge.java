package pokerapp.view.playerhand;

import pokerapp.Dealer;
import pokerapp.InteractivePlayer;
import pokerapp.Players;
import pokerapp.scorer.HandScorerBuilder;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import javax.swing.*;
import java.io.IOException;

/**
 * Bridge pattern for the display of the presenters hand 
 * TODO: why is this implementing the bridge pattern
 * @author steve
 *
 */
public class PlayerHandPresenterBridge {

  private final PlayerHandPresenter handPresenter;
  private final Dealer dealer;
  private InteractivePlayer player;

  public PlayerHandPresenterBridge(PlayerHandPresenter phPresenter, Dealer dealer) {
    handPresenter = phPresenter;
    this.dealer = dealer;
  }

  public void playRandomHand() throws FormatStringException, IOException, IllegalFormatCodeException {
    InteractivePlayer ip = new InteractivePlayer();
    Players players = new Players(new HandScorerBuilder().create()).register(ip);

    dealer.dealCards(5, players);
    handPresenter.init(ip, ip.getHand());
  }

  public JComponent getView() {
    return handPresenter.getView();
  }

  public void setPlayer(InteractivePlayer player) throws FormatStringException, IOException,
      IllegalFormatCodeException {
    this.player = player;
    handPresenter.init(player, player.getHand());
  }

  public InteractivePlayer getPlayer() {
    return player;
  }
}
