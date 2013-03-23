package view.playerhand;

import pokerapp.Dealer;
import pokerapp.console.InteractivePlayer;
import pokerapp.console.Players;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import javax.swing.*;
import java.io.IOException;

public class PlayerHandPresenterBridge {

  private final PlayerHandPresenter handPresenter;
  private final Dealer dealer;

  public PlayerHandPresenterBridge(PlayerHandPresenter phPresenter, Dealer dealer) {
    handPresenter = phPresenter;
    this.dealer = dealer;
  }

  public void playRandomHand() throws FormatStringException, IOException, IllegalFormatCodeException {
    InteractivePlayer ip = new InteractivePlayer();
    Players players = new Players().register(ip);

    dealer.dealCards(5, players);
    handPresenter.init(ip, ip.getHand());
  }

  public JComponent getView() {
    return handPresenter.getView();
  }

}
