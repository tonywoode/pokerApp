package pokerapp.view.hand.testsvisual;

import pokerapp.Card;
import pokerapp.Rank;
import pokerapp.Suit;
import pokerapp.view.ImageView;
import pokerapp.view.hand.CardViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Displays a full suit of cards, user can change suit 
 */
public class HandRunner {

  public static void main(String[] args) {

    final JFrame frame = new JFrame("Load Image Sample");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    JPanel cardsPanel = new JPanel();
    cardsPanel.setLayout(new FlowLayout());
    final ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    final int MAX_CARDS = 15;

    for (Rank rank : Rank.values()) {

      Card card = new Card(Suit.Hearts, rank);
      CardViewModel cardVM = CardViewModel.create(card);

      ImageView imageView = new ImageView(0);
      imageView.setImage(cardVM.getImage());

      imageViews.add(imageView);
      cardsPanel.add(imageView);
    }

    JComboBox<Suit> suitsComboBox = new JComboBox<Suit>(Suit.AllSuits);
    suitsComboBox.setSelectedIndex(1);

    suitsComboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JComboBox<Suit> cb = (JComboBox<Suit>) e.getSource();
        Suit suit = (Suit) cb.getSelectedItem();

        // change all the images
        int iter = 0;
        for (Rank rank : Rank.values()) {
          Card card = new Card(suit, rank);
          CardViewModel cardVM = CardViewModel.create(card);

          imageViews.get(iter++).setImage(cardVM.getImage());
        }
      }
    });

    frame.setLayout(new BorderLayout());

    frame.add(cardsPanel, BorderLayout.NORTH);
    frame.add(suitsComboBox, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }

}
