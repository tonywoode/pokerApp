package pokerapp.view.hand;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.ImageView;
import pokerapp.view.card.CardImageFactory;
import pokerapp.view.card.CardViewModelFactory;
import pokerapp.view.card.NullCardImageFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interactive functions for hand panels
 * @author Steve
 * @author Tony
 * @version 2
 */
public class SuperHandPanel extends JPanel {

  private final CardViewModelFactory cardViewModelFactory;
  private final List<ImageView> imageViews = new ArrayList<>();
  private final List<CardViewModel> cards = new ArrayList<>();
  
  private boolean mouseListenerEnable = true;
  
  private Hand hand;
  
  public SuperHandPanel(final int numCards, CardViewModelFactory cardViewModelFactory) {
    this.cardViewModelFactory = cardViewModelFactory;
    setOpaque(false);
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setLayout(new FlowLayout());
    for (int iter = 0; iter < numCards; ++iter) {
      ImageView imageView = new ImageView(iter);
      imageViews.add(imageView);
      this.add(imageView);
      

      imageView.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
        	if (mouseListenerEnable) {
          ImageView iv = (ImageView) e.getSource();

          CardViewModel cardVM = cards.get(iv.getIndex());

          cardVM.setIsSelected(!cardVM.getIsSelected());

          iv.setImage(cardVM.getImage());
        	}}
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
      });
    }
  }

  /**
   * passes hands to a hand view model
   * @param hand a hand of cards
   * @throws FormatStringException
   * @throws IOException
   * @throws IllegalFormatCodeException
   */
  public void setHand(Hand hand) throws FormatStringException, IOException, IllegalFormatCodeException {
    this.hand = hand;
    this.cards.clear();
    int iter = 0;
    for (Card card : hand) {
      CardViewModel cvm = cardViewModelFactory.create(card);
      imageViews.get(iter++).setImage(cvm.getImage());
      this.cards.add(cvm);
    }
  }

  /**
   * Gets selected cards a card view model
   * @return arraylist of selected cards
   */
  public List<Card> getSelectedCards() {
    List<Card> selectedCards = new ArrayList<>();
    for (CardViewModel cvm : cards)
      if (cvm.getIsSelected())
        selectedCards.add(cvm.getCard());
    return selectedCards;
  }

  public void setCardViewFactory(CardImageFactory ciFactory) throws FormatStringException, IOException,
      IllegalFormatCodeException {
    int iter = 0;
    for (Card card : hand) {
      CardViewModel cvm = new CardViewModelFactory(ciFactory, new NullCardImageFactory()).create(card);
      imageViews.get(iter++).setImage(cvm.getImage());
      this.cards.add(cvm);
    }
  }

  public void popUpCard(int index) {
    ImageView iv = imageViews.get(index);

    iv.setBottomPadding(100);

    //Insets insets = iv.getInsets();

    //insets.set(0, 0, 100, 0);
  }
  
  
  /**
   * Turns off and on user interation with a hand panel
   * @param enable interaction permitted when true
   */
  public void handPanelEnable(boolean enable) {
		this.setEnabled(enable); 
		mouseListenerEnable = enable;
		if (enable == true) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
}
  }
}

