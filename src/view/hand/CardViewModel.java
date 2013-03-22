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
  @Setter
  boolean isSelected;

  @Getter
  BufferedImage image; // how's this set?
  private BufferedImage selectedImage;
  private BufferedImage unselectedImage;

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
    return ("" + card.getSuit().getCode()).toLowerCase() + card.getRank().getSymbol() + ".gif";
  }

  public void setSelectedImage(BufferedImage selectedImage) {
    this.selectedImage = selectedImage;
  }

  public BufferedImage getSelectedImage() {
    return selectedImage;
  }

  public BufferedImage getUnselectedImage() {
    return unselectedImage;
  }
}
