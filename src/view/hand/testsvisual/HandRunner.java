package view.hand.testsvisual;

import pokerapp.Card;
import pokerapp.Suit;
import view.ImageView;
import view.hand.CardViewModel;

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

    for (int iter = 2; iter != MAX_CARDS; ++iter) {

      Card card = new Card(Suit.Hearts, iter);
      CardViewModel cardVM = CardViewModel.create(card);

      ImageView imageView = new ImageView();
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
        for (int iter = 2; iter != MAX_CARDS; ++iter) {
          Card card = new Card(suit, iter);
          CardViewModel cardVM = CardViewModel.create(card);

          imageViews.get(iter - 2).setImage(cardVM.getImage());
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
