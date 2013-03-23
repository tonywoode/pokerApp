package pokerapp.view.imagefilters;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 16/03/13
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
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
