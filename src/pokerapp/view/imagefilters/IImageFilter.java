package pokerapp.view.imagefilters;

import java.awt.image.BufferedImage;

/**
 * Interface for the image filter which will denote selected cards
 * @author Sam
 * @version 1
 */
public interface IImageFilter {
    BufferedImage filter(BufferedImage src);
}
