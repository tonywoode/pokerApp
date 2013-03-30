package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpRecoGrammar Interface
 */
@IID("{2177DB29-7F45-47D0-8554-067E91C80502}")
public interface ISpRecoGrammar extends ISpGrammarBuilder {
  // Methods:
  /**
   * @return  Returns a value of type long
   */

  @VTID(11)
  long getGrammarId();


  /**
   * @return  Returns a value of typeISpRecoContext
   */

  @VTID(12)
 ISpRecoContext getRecoContext();


  /**
   * @param pszFileName Mandatory java.lang.String parameter.
   * @param options MandatorySPLOADOPTIONS parameter.
   */

  @VTID(13)
  void loadCmdFromFile(
    @MarshalAs(NativeType.Unicode) java.lang.String pszFileName,
   SPLOADOPTIONS options);


  /**
   * @param rcid Mandatory GUID parameter.
   * @param pszGrammarName Mandatory java.lang.String parameter.
   * @param options MandatorySPLOADOPTIONS parameter.
   */

  @VTID(14)
  void loadCmdFromObject(
    GUID rcid,
    @MarshalAs(NativeType.Unicode) java.lang.String pszGrammarName,
   SPLOADOPTIONS options);


  /**
   * @param hModule Mandatory java.nio.Buffer parameter.
   * @param pszResourceName Mandatory java.lang.String parameter.
   * @param pszResourceType Mandatory java.lang.String parameter.
   * @param wLanguage Mandatory short parameter.
   * @param options MandatorySPLOADOPTIONS parameter.
   */

  @VTID(15)
  void loadCmdFromResource(
    java.nio.Buffer hModule,
    @MarshalAs(NativeType.Unicode) java.lang.String pszResourceName,
    @MarshalAs(NativeType.Unicode) java.lang.String pszResourceType,
    short wLanguage,
   SPLOADOPTIONS options);


    /**
     * @param rguidParam Mandatory GUID parameter.
     * @param pszStringParam Mandatory java.lang.String parameter.
     * @param pvDataPrarm Mandatory java.nio.Buffer parameter.
     * @param cbDataSize Mandatory int parameter.
     * @param options MandatorySPLOADOPTIONS parameter.
     */

    @VTID(17)
    void loadCmdFromProprietaryGrammar(
      GUID rguidParam,
      @MarshalAs(NativeType.Unicode) java.lang.String pszStringParam,
      java.nio.Buffer pvDataPrarm,
      int cbDataSize,
     SPLOADOPTIONS options);


    /**
     * @param pszName Mandatory java.lang.String parameter.
     * @param pReserved Mandatory java.nio.Buffer parameter.
     * @param newState MandatorySPRULESTATE parameter.
     */

    @VTID(18)
    void setRuleState(
      @MarshalAs(NativeType.Unicode) java.lang.String pszName,
      java.nio.Buffer pReserved,
     SPRULESTATE newState);


    /**
     * @param ulRuleId Mandatory int parameter.
     * @param newState MandatorySPRULESTATE parameter.
     */

    @VTID(19)
    void setRuleIdState(
      int ulRuleId,
     SPRULESTATE newState);


    /**
     * @param pszTopicName Mandatory java.lang.String parameter.
     * @param options MandatorySPLOADOPTIONS parameter.
     */

    @VTID(20)
    void loadDictation(
      @MarshalAs(NativeType.Unicode) java.lang.String pszTopicName,
     SPLOADOPTIONS options);


    /**
     */

    @VTID(21)
    void unloadDictation();


    /**
     * @param newState MandatorySPRULESTATE parameter.
     */

    @VTID(22)
    void setDictationState(
     SPRULESTATE newState);


        /**
         * @param pszWord Mandatory java.lang.String parameter.
         * @return  Returns a value of typeSPWORDPRONOUNCEABLE
         */

        @VTID(25)
       SPWORDPRONOUNCEABLE isPronounceable(
          @MarshalAs(NativeType.Unicode) java.lang.String pszWord);


        /**
         * @param eGrammarState MandatorySPGRAMMARSTATE parameter.
         */

        @VTID(26)
        void setGrammarState(
         SPGRAMMARSTATE eGrammarState);


        /**
         * @param pStream MandatoryIStream parameter.
         * @return  Returns a value of type Holder<Short>
         */

        @VTID(27)
        Holder<Short> saveCmd(
         IStream pStream);


        /**
         * @return  Returns a value of typeSPGRAMMARSTATE
         */

        @VTID(28)
       SPGRAMMARSTATE getGrammarState();


        // Properties:
      }
