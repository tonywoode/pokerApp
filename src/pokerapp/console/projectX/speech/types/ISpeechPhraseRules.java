package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechPhraseRules Interface
 */
@IID("{9047D593-01DD-4B72-81A3-E4A0CA69F407}")
public interface ISpeechPhraseRules extends Com4jObject,Iterable<Com4jObject> {
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
   * @return  Returns a value of typeISpeechPhraseRule
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(8)
  @DefaultMethod
 ISpeechPhraseRule item(
    int index);


  /**
   * <p>
   * Enumerates the Rules
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
