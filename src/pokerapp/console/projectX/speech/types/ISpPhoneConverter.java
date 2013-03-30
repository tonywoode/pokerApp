package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpPhoneConverter Interface
 */
@IID("{8445C581-0CAC-4A38-ABFE-9B2CE2826455}")
public interface ISpPhoneConverter extends ISpObjectWithToken {
  // Methods:
  /**
   * @param pszPhone Mandatory java.lang.String parameter.
   * @return  Returns a value of type short
   */

  @VTID(5)
  short phoneToId(
    @MarshalAs(NativeType.Unicode) java.lang.String pszPhone);


  /**
   * @param pId Mandatory Holder<Short> parameter.
   * @return  Returns a value of type short
   */

  @VTID(6)
  short idToPhone(
    Holder<Short> pId);


  // Properties:
}
