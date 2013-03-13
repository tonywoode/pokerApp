package view.hand;

import lombok.Getter;
import lombok.Setter;
import pokerapp.Card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 09/03/13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class CardViewModel {

  @Getter
  @Setter
  Card card;

  @Getter
  boolean isSelected;

  @Getter
  BufferedImage image; // how's this set?

  public CardViewModel(Card card, BufferedImage image) {
    this.card = card;
    this.image = image;
  }

  public static CardViewModel create(Card card) {
    String filename = filenameFromCard(card);

    BufferedImage img;
    try {
      img = ImageIO.read(new File("pics/" + filename));
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage() + " - " + filename);
      return null; // TODO: fix this...
    }

    return new CardViewModel(card, img);
  }

  private static String filenameFromCard(Card card) {
    return ("" + card.getSuit().getCode()).toLowerCase() + getRankString(card.getRank()) + ".gif";
  }

  private static char getRankString(int rank) {
    if (rank >= 0 && rank <= 10)
      return (char) ('0' + rank);
    else
      switch (rank) {
        case 11:
          return 'J';
        case 12:
          return 'Q';
        case 13:
          return 'K';
        case 14:
          return 'A';
        default:
          throw new IllegalArgumentException("Illegal rank");
      }

  }

}
