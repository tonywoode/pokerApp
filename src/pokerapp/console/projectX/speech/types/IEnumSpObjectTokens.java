package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * IEnumSpObjectTokens Interface
 */
@IID("{06B64F9E-7FDA-11D2-B4F2-00C04F797396}")
public interface IEnumSpObjectTokens extends Com4jObject {
  // Methods:
  /**
   * @param celt Mandatory int parameter.
   * @param pelt Mandatory Holder<ISpObjectToken> parameter.
   * @param pceltFetched Mandatory Holder<Integer> parameter.
   */

  @VTID(3)
  void next(
    int celt,
    Holder<ISpObjectToken> pelt,
    Holder<Integer> pceltFetched);


  /**
   * @param celt Mandatory int parameter.
   */

  @VTID(4)
  void skip(
    int celt);


  /**
   */

  @VTID(5)
  void reset();


  /**
   * @return  Returns a value of typeIEnumSpObjectTokens
   */

  @VTID(6)
 IEnumSpObjectTokens clone();


  /**
   * @param index Mandatory int parameter.
   * @return  Returns a value of typeISpObjectToken
   */

  @VTID(7)
 ISpObjectToken item(
    int index);


  /**
   * @return  Returns a value of type int
   */

  @VTID(8)
  int getCount();


  // Properties:
}
