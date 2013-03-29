package pokerapp.view.hand;

import lombok.Getter;
import pokerapp.Card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * Methods for selecting card images and rendering them based on their selection status ie: whether user has
 * selected cards to change
 * @author Steve
 * @version 1
 */
public class CardViewModel {

  @Getter
  private final Card card;
  boolean isSelected;

  private BufferedImage selectedImage;
  private BufferedImage unselectedImage;

  public CardViewModel(Card card, BufferedImage image) {
    this.card = card;
    this.unselectedImage = image;
  }

  public CardViewModel(Card card, BufferedImage image, BufferedImage selectedImage) {
    this.card = card;
    this.unselectedImage = image;
    this.selectedImage = selectedImage;
  }

  public BufferedImage getImage() {
    return getIsSelected() ? selectedImage : unselectedImage;
  }  
  
  public static CardViewModel create(Card card) throws IOException {
    String filename = filenameFromCard(card);

    return new CardViewModel(card, ImageIO.read(new File("pics/" + filename)));
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

  public boolean getIsSelected() {
    return isSelected;
  }

  public void setIsSelected(boolean sel) {
    isSelected = sel;
  }  
}
