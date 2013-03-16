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
 * Just displays a hand panel, for testing
 * @author Tony
 *
 */
public class HandPanelRunner {

  public static void main(String[] args) {

    final JFrame frame = new JFrame("Load Image Sample");
    JPanel cardRender = new HandPanel();

    frame.setLayout(new BorderLayout());
    
    frame.add(cardRender, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

}
