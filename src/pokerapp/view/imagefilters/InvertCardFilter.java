package pokerapp.view.imagefilters;

import com.jhlabs.image.InvertFilter;

import java.awt.image.BufferedImage;

/**
 * Imp for using jhlabs InvertFilter on a buffered image
 * @author Sam
 * @version 1
 */
public class InvertCardFilter implements IImageFilter {

    @Override
    public BufferedImage filter(BufferedImage src) {
        InvertFilter invertFilter = new InvertFilter();

        return invertFilter.filter(src, src);
    }
}
