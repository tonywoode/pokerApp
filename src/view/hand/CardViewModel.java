package view.hand;

import lombok.Getter;
import lombok.Setter;
import pokerapp.Card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Provides UI specific functionality to the domain concept of a poker card.
 * 
 * Specifically, it adds selection and the card image
 * 
 * It also knows how to load the card's image (TODO: should it?)
 * 
 * @author Steve
 */
public class CardViewModel {

  @Getter
  @Setter
  Card card;

  @Getter
  boolean isSelected; // tracks selection state... i.e., if the user has selected the card on screen

  @Getter
  BufferedImage image; // set using the static factory method

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
  //TODO: no no no use the enum...but how many other classes will that effect eh?
  
  private static String getRankString(int rank) {
    if (rank >= 0 && rank < 11)
      return (Integer.toString(rank));
    else
      switch (rank) {
        /*case 10:
          return "10";*/
        case 11:
          return "J";
        case 12:
          return "Q";
        case 13:
          return "K";
        case 14:
          return "A";
        default:
          throw new IllegalArgumentException("Illegal rank");
      }

  }

}
