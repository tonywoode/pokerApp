package pokerapp.skynet;

/**
 * <p>
 *   A mockable random number generator.
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class RandomNumberGenerator {

  public int nextInteger(int min, int max) {
    // adapted from: http://stackoverflow.com/questions/363681/generating-random-number-in-a-range-with-java
    return min + (int)(Math.random() * ((max - min) + 1));
  }

}
