package pokerapp.view.card;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 * Deals with rendering and providing images to pokerapp
 *
 * @author Steve
 * @version 1
 */
public class CardImage extends CardView {
  private final BufferedImage image;

  public CardImage(BufferedImage image) {
    this.image = image;
  }

  @Override
  public void render(Graphics g) {
    if (image != null)
      g.drawImage(image, 0, 0, null);
  }

  /**
   * Copies image so that image can be manipulated e.g.: selection effect
   */
  @Override
  public BufferedImage copyImage() {
    ColorModel cm = image.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = image.copyData(null);
    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
  }

  public BufferedImage getImage() {
    return image;
  }
}
