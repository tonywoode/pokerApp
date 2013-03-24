package pokerapp.view.imagefilters;

import com.jhlabs.image.ThresholdFilter;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 16/03/13
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class ThresholdCardFilter implements IImageFilter {
    @Override
    public BufferedImage filter(BufferedImage src) {
        ThresholdFilterWithoutRed thresholdFilter = new ThresholdFilterWithoutRed();

        return thresholdFilter.filter(src, src);

    }
}
