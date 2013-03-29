package pokerapp.view.imagefilters;

import com.jhlabs.image.ThresholdFilter;

import java.awt.image.BufferedImage;

/**
 * * Imp for using jhlabs ThresholdFilter on a buffered image
 * @author Sam
 * @version 1
 */
public class ThresholdCardFilter implements IImageFilter {
    @Override
    public BufferedImage filter(BufferedImage src) {
        ThresholdFilterWithoutRed thresholdFilter = new ThresholdFilterWithoutRed();

        return thresholdFilter.filter(src, src);

    }
}
