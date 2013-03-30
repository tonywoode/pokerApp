package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpProperties Interface
 */
@IID("{5B4FB971-B115-4DE1-AD97-E482E3BF6EE4}")
public interface ISpProperties extends Com4jObject {
  // Methods:
  /**
   * @param pName Mandatory Holder<Short> parameter.
   * @param lValue Mandatory int parameter.
   */

  @VTID(3)
  void setPropertyNum(
    Holder<Short> pName,
    int lValue);


  /**
   * @param pName Mandatory Holder<Short> parameter.
   * @return  Returns a value of type int
   */

  @VTID(4)
  int getPropertyNum(
    Holder<Short> pName);


  /**
   * @param pName Mandatory Holder<Short> parameter.
   * @param pValue Mandatory Holder<Short> parameter.
   */

  @VTID(5)
  void setPropertyString(
    Holder<Short> pName,
    Holder<Short> pValue);


  /**
   * @param pName Mandatory Holder<Short> parameter.
   * @return  Returns a value of type Holder<Short>
   */

  @VTID(6)
  Holder<Short> getPropertyString(
    Holder<Short> pName);


  // Properties:
}
