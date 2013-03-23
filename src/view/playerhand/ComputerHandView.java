package view.playerhand;

import pokerapp.Hand;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import view.Displayable;
import view.card.CardImageFactory;
import view.hand.SuperHandPanel;

import javax.swing.*;
import java.io.IOException;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class ComputerHandView implements Displayable {
  private final SuperHandPanel handView;
  private final CardImageFactory ciFactory;
  private Hand hand;

  public ComputerHandView(SuperHandPanel handView, CardImageFactory ciFactory) {
    this.handView = handView;
    this.ciFactory = ciFactory;
  }

  public void setHand(Hand hand) throws FormatStringException, IOException, IllegalFormatCodeException {
    this.hand = hand;
    this.handView.setHand(hand);
  }

  public void showCards() throws FormatStringException, IOException, IllegalFormatCodeException {
    // TOOO: this is unbelievably hacky... but I haven't figured out a better way

    handView.__hack_setCardViewFactory(ciFactory);
  }

  @Override
  public JComponent getView() {
    return handView;
  }

  public void popUpCard(int index) {
    handView.popUpCard(index);
  }
}
