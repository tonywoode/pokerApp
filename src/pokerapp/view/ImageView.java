package pokerapp.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 09/03/13
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
public class ImageView extends JComponent {

  @Getter
  private BufferedImage image;

  @Getter
  private int index;
  private int cx, cy;
  private int bottomPadding;

  private int topPadding;

  public ImageView(int index) {
    this.index = index;
  }

  public void setImage(BufferedImage img) {
    this.image = img;
    cx = image.getWidth(null);
    cy = image.getHeight(null);
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null)
      g.drawImage(image, 0, 0, null);
  }

  @Override
  public Dimension getPreferredSize() {
    if (image == null) {
      return new Dimension(100, 100);
    } else {
      return new Dimension(cx, cy + bottomPadding + topPadding);
    }
  }

  public void setBottomPadding(int bottomPadding) {
    this.bottomPadding = bottomPadding;
    this.revalidate();
  }

  public int getBottomPadding() {
    return bottomPadding;
  }

  public int getTopPadding() {
    return topPadding;
  }

  public void setTopPadding(int topPadding) {
    this.topPadding = topPadding;
    this.doLayout();
  }

}
