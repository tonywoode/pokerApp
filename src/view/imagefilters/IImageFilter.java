package view.imagefilters;

import view.hand.CardViewModel;

import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Samuel Keays
 * Date: 16/03/13
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public interface IImageFilter {
    BufferedImage filter(BufferedImage src);
}
