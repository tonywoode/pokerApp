package view.card;

import java.awt.*;
import java.awt.image.BufferedImage;

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
public abstract class CardView {

  public abstract void render(Graphics g);

  // TODO: not happy with this
  public abstract BufferedImage copyImage();
}
