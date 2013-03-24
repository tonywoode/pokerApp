package pokerapp.view.imagefilters;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 24/03/13
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
public class InvertFilterWithoutRed extends com.jhlabs.image.InvertFilter {

    @Override
    public int filterRGB(int x, int y, int rgb)
    {
        int cond = rgb ^ 0x00ff0000;
        if(cond > 0)
            return super.filterRGB(x,y,rgb);
        return rgb;
    }

}
