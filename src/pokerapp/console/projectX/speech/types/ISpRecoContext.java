package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpRecoContext Interface
 */
@IID("{F740A62F-7C15-489E-8234-940A33D9272D}")
public interface ISpRecoContext extends ISpEventSource {
  // Methods:
  /**
   * @return  Returns a value of typeISpRecognizer
   */

  @VTID(13)
 ISpRecognizer getRecognizer();


  /**
   * @param ullGrammarID Mandatory long parameter.
   * @return  Returns a value of typeISpRecoGrammar
   */

  @VTID(14)
 ISpRecoGrammar createGrammar(
    long ullGrammarID);


  /**
   * @param pcAlternates Mandatory Holder<Integer> parameter.
   */

  @VTID(16)
  void getMaxAlternates(
    Holder<Integer> pcAlternates);


  /**
   * @param cAlternates Mandatory int parameter.
   */

  @VTID(17)
  void setMaxAlternates(
    int cAlternates);


        /**
         * @param options MandatorySPBOOKMARKOPTIONS parameter.
         * @param ullStreamPosition Mandatory long parameter.
         * @param lparamEvent Mandatory int parameter.
         */

        @VTID(21)
        void bookmark(
         SPBOOKMARKOPTIONS options,
          long ullStreamPosition,
          int lparamEvent);


        /**
         * @param pAdaptationData Mandatory java.lang.String parameter.
         * @param cch Mandatory int parameter.
         */

        @VTID(22)
        void setAdaptationData(
          @MarshalAs(NativeType.Unicode) java.lang.String pAdaptationData,
          int cch);


        /**
         * @param dwReserved Mandatory int parameter.
         */

        @VTID(23)
        void pause(
          int dwReserved);


        /**
         * @param dwReserved Mandatory int parameter.
         */

        @VTID(24)
        void resume(
          int dwReserved);


        /**
         * @param pVoice MandatoryISpVoice parameter.
         * @param fAllowFormatChanges Mandatory int parameter.
         */

        @VTID(25)
        void setVoice(
         ISpVoice pVoice,
          int fAllowFormatChanges);


        /**
         * @return  Returns a value of typeISpVoice
         */

        @VTID(26)
       ISpVoice getVoice();


        /**
         * @param ullEventInterest Mandatory long parameter.
         */

        @VTID(27)
        void setVoicePurgeEvent(
          long ullEventInterest);


        /**
         * @return  Returns a value of type long
         */

        @VTID(28)
        long getVoicePurgeEvent();


        /**
         * @param eContextState MandatorySPCONTEXTSTATE parameter.
         */

        @VTID(29)
        void setContextState(
         SPCONTEXTSTATE eContextState);


        /**
         * @param peContextState Mandatory Holder<SPCONTEXTSTATE> parameter.
         */

        @VTID(30)
        void getContextState(
          Holder<SPCONTEXTSTATE> peContextState);


        // Properties:
      }
