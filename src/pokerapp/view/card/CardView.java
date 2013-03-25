package pokerapp.view.card;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class, acting as a bridge to rendering and copying functions for images
 *
 * @author Steve
 * @version 1
 */
public abstract class CardView {

  public abstract void render(Graphics g);

  // TODO: not happy with this
  public abstract BufferedImage copyImage();
}
