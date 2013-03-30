package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechLexiconPronunciations Interface
 */
@IID("{72829128-5682-4704-A0D4-3E2BB6F2EAD3}")
public interface ISpeechLexiconPronunciations extends Com4jObject,Iterable<Com4jObject> {
  // Methods:
  /**
   * <p>
   * Count
   * </p>
   * <p>
   * Getter method for the COM property "Count"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  int count();


  /**
   * <p>
   * Item
   * </p>
   * @param index Mandatory int parameter.
   * @return  Returns a value of typeISpeechLexiconPronunciation
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(8)
  @DefaultMethod
 ISpeechLexiconPronunciation item(
    int index);


  /**
   * <p>
   * Enumerates the tokens
   * </p>
   * <p>
   * Getter method for the COM property "_NewEnum"
   * </p>
   */

  @DISPID(-4) //= 0xfffffffc. The runtime will prefer the VTID if present
  @VTID(9)
  java.util.Iterator<Com4jObject> iterator();

  // Properties:
}
