package pokerapp.view.hand;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.Card;
import pokerapp.Rank;
import pokerapp.Suit;
import pokerapp.view.ImageView;
import pokerapp.view.imagefilters.IImageFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sam
 * Date: 09/03/13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */

public class FilteredHandRunner {

  private IImageFilter selectedImageFilter;
  private java.util.List<CardViewModel> cardViewModelList = new ArrayList<CardViewModel>();

  public FilteredHandRunner(IImageFilter filter) {
    this.selectedImageFilter = filter;
  }

  public static void main(String[] args) {
    try {
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/gui-game-application-context.xml");
      //gets the bean, cast it to ConsoleGame, a Spring managed object
      FilteredHandRunner game = (FilteredHandRunner) appContext.getBean("filteredHandRunner");

      game.run();

    } catch (BeansException e) {
      System.out.println("Error:" + e.getMessage());
    }

    System.out.println("Exiting...");
  }

  public void run() {
    final JFrame frame = new JFrame("Load Image Sample");
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    JPanel cardsPanel = new JPanel();
    cardsPanel.setLayout(new FlowLayout());
    final ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    int iter = 0;
    for (Rank rank : Rank.values()) {

      Card card = new Card(Suit.Hearts, rank);
      CardViewModel cardVM = CardViewModel.create(card);
      cardViewModelList.add(cardVM);

      BufferedImage img = cardVM.getImage();

      if (iter % 2 == 0) {
        BufferedImage filteredImg;
        filteredImg = selectedImageFilter.filter(cloneImage(img));
        cardVM.setIsSelected(true);
        cardVM.setSelectedImage(filteredImg);
        img = filteredImg;
      }

      ImageView imageView = new ImageView(iter - 2);

      imageView.addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
          ImageView iv = (ImageView) e.getSource();

          CardViewModel cardVM = cardViewModelList.get(iv.getIndex());

          cardVM.setIsSelected(!cardVM.getIsSelected());

          iv.setImage(cardVM.getImage());

        }

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

      imageView.setImage(img);

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
        cardViewModelList.clear();

        // change all the images
        int iter = 0;
        for (Rank rank : Rank.values()) {
          Card card = new Card(suit, rank);
          CardViewModel cardVM = CardViewModel.create(card);
          cardViewModelList.add(cardVM);

          BufferedImage img = cardVM.getImage();

          if (iter % 2 == 0) {
            BufferedImage filteredImg;
            filteredImg = selectedImageFilter.filter(cloneImage(img));
            cardVM.setIsSelected(true);
            cardVM.setSelectedImage(filteredImg);
            img = filteredImg;
          }

          imageViews.get(iter - 2).setImage(img);
        }
      }
    });

    frame.setLayout(new BorderLayout());

    frame.add(cardsPanel, BorderLayout.NORTH);
    frame.add(suitsComboBox, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }

  //code from http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage

  BufferedImage cloneImage(BufferedImage img) {
    ColorModel cm = img.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = img.copyData(null);
    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
  }

}
