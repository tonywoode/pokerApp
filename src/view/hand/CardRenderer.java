package view.hand;

import pokerapp.Card;
import pokerapp.Suit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 09/03/13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class CardRenderer extends JPanel {

 public CardRenderer() {
    //JPanel cardsPanel = new JPanel();
    this.setLayout(new FlowLayout());
    final ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    final int MAX_CARDS = 7;

    for (int iter = 2; iter != MAX_CARDS; ++iter) {

      Card card = new Card(Suit.Hearts, iter);
      CardViewModel cardVM = CardViewModel.create(card);

      ImageView imageView = new ImageView();
      imageView.setImage(cardVM.getImage());

      imageViews.add(imageView);
      this.add(imageView);
    }

  }
}


