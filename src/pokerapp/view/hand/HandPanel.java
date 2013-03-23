package pokerapp.view.hand;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Rank;
import pokerapp.Suit;
import pokerapp.view.ImageView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class HandPanel extends JPanel {

  /**
   * Displays a hand of cards in a panel
   *
   * @author tony
   * @wbp.factory
   */

  private final ArrayList<ImageView> imageViews = new ArrayList<>();
  private final ArrayList<CardViewModel> cards = new ArrayList<>();

  public HandPanel() {
    setOpaque(false);
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setLayout(new FlowLayout());

    final int MAX_CARDS = 7;

    for (Rank rank : Rank.values()) {

      Card card = new Card(Suit.Clubs, rank);
      CardViewModel cardVM = CardViewModel.create(card);

      ImageView imageView = new ImageView(0);
      imageView.setImage(cardVM.getImage());

      imageViews.add(imageView);
      this.add(imageView);

    }

  }

  public HandPanel(Hand hand) {
    setOpaque(false);
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setLayout(new FlowLayout());

    final int MAX_CARDS = 7;

    for (Rank rank : Rank.values()) {

      Card card = new Card(Suit.Clubs, rank);
      CardViewModel cardVM = CardViewModel.create(card);

      ImageView imageView = new ImageView(0);
      imageView.setImage(cardVM.getImage());

      imageViews.add(imageView);
      this.add(imageView);

    }

  }

  public List<Card> getSelectedCards() {
    return null;
  }

  public void setCards(Iterable<CardViewModel> cards) {
    int iter = 0;
    this.cards.clear();
    for (CardViewModel card : cards) {
      imageViews.get(iter++).setImage(card.getImage());
      this.cards.add(card);
    }
  }
}
