package view.card;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

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
