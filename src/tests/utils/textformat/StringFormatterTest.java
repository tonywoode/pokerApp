package tests.utils.textformat;

import org.junit.Test;
import org.springframework.test.annotation.ExpectedException;
import pokerapp.Suit;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.StringFormatter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

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
public class StringFormatterTest {
  @Test
  public void testFormat_PositionOnly() throws Exception {
    String msg = "Simple Replacement: {0} | {1} | {2}";

    String expected = "Simple Replacement: 17 | Steve | ♣";

    String output = new StringFormatter().format(msg, 17, "Steve", Suit.Clubs);

    assertEquals(expected, output);
  }

  @Test
  @ExpectedException(value = FormatStringException.class)
  public void testFormat_IllegalPosition() throws Exception {
    String msg = "Simple Replacement: {0} | {1} | {2}";

    try {

      new StringFormatter().format(msg, 17, "Steve");

      fail();

    } catch (FormatStringException e) {
      // pass
    }
  }

  @Test
  public void testFormat_formattable() throws Exception {

    String msg = "Simple Replacement: {0} | {1} | {2:m}";

    String expected = "Simple Replacement: 17 | Steve | Clubs";

    String output = new StringFormatter().format(msg, 17, "Steve", Suit.Clubs);

    assertEquals(expected, output);

  }
}
