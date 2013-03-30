package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpObjectWithToken Interface
 */
@IID("{5B559F40-E952-11D2-BB91-00C04F8EE6C0}")
public interface ISpObjectWithToken extends Com4jObject {
  // Methods:
  /**
   * @param pToken MandatoryISpObjectToken parameter.
   */

  @VTID(3)
  void setObjectToken(
   ISpObjectToken pToken);


  /**
   * @param ppToken Mandatory Holder<ISpObjectToken> parameter.
   */

  @VTID(4)
  void getObjectToken(
    Holder<ISpObjectToken> ppToken);


  // Properties:
}
