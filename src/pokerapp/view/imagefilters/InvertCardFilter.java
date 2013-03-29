package pokerapp.view.imagefilters;

import com.jhlabs.image.InvertFilter;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 16/03/13
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class InvertCardFilter implements IImageFilter {

    @Override
    public BufferedImage filter(BufferedImage src) {
      //InvertFilterWithoutRed invertFilter = new InvertFilterWithoutRed();

      InvertFilter invertFilter = new InvertFilter();

      return invertFilter.filter(src, src);
    }
}
