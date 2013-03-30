package pokerapp;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public interface InteractivePlayerGameResultHandler {

  public void gameWon(GameResult result);
  public void gameLost(GameResult result);
  public void gameTied(GameResult result);

}