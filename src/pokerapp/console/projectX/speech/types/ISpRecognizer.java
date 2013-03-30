package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpRecognizer Interface
 */
@IID("{C2B5F241-DAA0-4507-9E16-5A1EAA2B7A5C}")
public interface ISpRecognizer extends ISpProperties {
  // Methods:
  /**
   * @param pRecognizer MandatoryISpObjectToken parameter.
   */

  @VTID(7)
  void setRecognizer(
   ISpObjectToken pRecognizer);


  /**
   * @return  Returns a value of typeISpObjectToken
   */

  @VTID(8)
 ISpObjectToken getRecognizer();


  /**
   * @param pUnkInput Mandatory com4j.Com4jObject parameter.
   * @param fAllowFormatChanges Mandatory int parameter.
   */

  @VTID(9)
  void setInput(
    com4j.Com4jObject pUnkInput,
    int fAllowFormatChanges);


  /**
   * @return  Returns a value of typeISpObjectToken
   */

  @VTID(10)
 ISpObjectToken getInputObjectToken();


  /**
   * @return  Returns a value of typeISpStreamFormat
   */

  @VTID(11)
 ISpStreamFormat getInputStream();


  /**
   * @return  Returns a value of typeISpRecoContext
   */

  @VTID(12)
 ISpRecoContext createRecoContext();


  /**
   * @return  Returns a value of typeISpObjectToken
   */

  @VTID(13)
 ISpObjectToken getRecoProfile();


  /**
   * @param pToken MandatoryISpObjectToken parameter.
   */

  @VTID(14)
  void setRecoProfile(
   ISpObjectToken pToken);


  /**
   */

  @VTID(15)
  void isSharedInstance();


  /**
   * @return  Returns a value of typeSPRECOSTATE
   */

  @VTID(16)
 SPRECOSTATE getRecoState();


  /**
   * @param newState MandatorySPRECOSTATE parameter.
   */

  @VTID(17)
  void setRecoState(
   SPRECOSTATE newState);


    /**
     * @param pszTypeOfUI Mandatory java.lang.String parameter.
     * @param pvExtraData Mandatory java.nio.Buffer parameter.
     * @param cbExtraData Mandatory int parameter.
     * @return  Returns a value of type int
     */

    @VTID(20)
    int isUISupported(
      @MarshalAs(NativeType.Unicode) java.lang.String pszTypeOfUI,
      java.nio.Buffer pvExtraData,
      int cbExtraData);


    /**
     * @param hWndParent Mandatory int parameter.
     * @param pszTitle Mandatory java.lang.String parameter.
     * @param pszTypeOfUI Mandatory java.lang.String parameter.
     * @param pvExtraData Mandatory java.nio.Buffer parameter.
     * @param cbExtraData Mandatory int parameter.
     */

    @VTID(21)
    void displayUI(
      int hWndParent,
      @MarshalAs(NativeType.Unicode) java.lang.String pszTitle,
      @MarshalAs(NativeType.Unicode) java.lang.String pszTypeOfUI,
      java.nio.Buffer pvExtraData,
      int cbExtraData);


    /**
     * @param pPhrase MandatoryISpPhrase parameter.
     */

    @VTID(22)
    void emulateRecognition(
     ISpPhrase pPhrase);


    // Properties:
  }
