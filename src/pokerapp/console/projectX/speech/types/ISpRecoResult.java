package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpRecoResult Interface
 */
@IID("{20B053BE-E235-43CD-9A2A-8D17A48B7842}")
public interface ISpRecoResult extends ISpPhrase {
  // Methods:
  /**
   * @param ulStartElement Mandatory int parameter.
   * @param cElements Mandatory int parameter.
   * @param ulRequestCount Mandatory int parameter.
   * @param ppPhrases Mandatory Holder<ISpPhraseAlt> parameter.
   * @param pcPhrasesReturned Mandatory Holder<Integer> parameter.
   */

  @VTID(8)
  void getAlternates(
    int ulStartElement,
    int cElements,
    int ulRequestCount,
    Holder<ISpPhraseAlt> ppPhrases,
    Holder<Integer> pcPhrasesReturned);


  /**
   * @param ulStartElement Mandatory int parameter.
   * @param cElements Mandatory int parameter.
   * @return  Returns a value of typeISpStreamFormat
   */

  @VTID(9)
 ISpStreamFormat getAudio(
    int ulStartElement,
    int cElements);


  /**
   * @param ulStartElement Mandatory int parameter.
   * @param cElements Mandatory int parameter.
   * @param dwFlags Mandatory int parameter.
   * @return  Returns a value of type int
   */

  @VTID(10)
  int speakAudio(
    int ulStartElement,
    int cElements,
    int dwFlags);


    /**
     * @return  Returns a value of typeISpRecoContext
     */

    @VTID(13)
   ISpRecoContext getRecoContext();


    // Properties:
  }
