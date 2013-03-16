package view.hand;

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

  public ImageView(){}

  public ImageView(int index)
  {
      this.index = index;
  }

  public void setImage(BufferedImage img) {
    this.image = img;
    this.repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    if (image != null)
      g.drawImage(image, 0, 0, null);
  }

  @Override
  public Dimension getPreferredSize() {
    if (image == null) {
      return new Dimension(100, 100);
    } else {
      return new Dimension(image.getWidth(null), image.getHeight(null));
    }
  }
}
