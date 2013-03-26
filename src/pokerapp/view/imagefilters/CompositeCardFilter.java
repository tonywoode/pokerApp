package pokerapp.view.imagefilters;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite filter allows applying multiple image filters to a single bufferedimage
 * @author Sam
 * @version 1
 */
public class CompositeCardFilter implements IImageFilter {
    private List<IImageFilter> childFilter = new ArrayList<IImageFilter>();

    public CompositeCardFilter(List<IImageFilter> filters)
    {
        for(IImageFilter filter : filters)
            childFilter.add(filter);
    }

    @Override
    public BufferedImage filter(BufferedImage src) {
            for (IImageFilter filter : childFilter) {
                src = filter.filter(src);
            }
        return src;
        }
}
