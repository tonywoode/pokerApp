package pokerapp.view.hand.testsvisual;

import pokerapp.view.hand.HandPanel;

import javax.swing.*;
import java.awt.*;

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
