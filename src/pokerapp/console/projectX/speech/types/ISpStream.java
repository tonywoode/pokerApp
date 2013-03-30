package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpStream Interface
 */
@IID("{12E3CCA9-7518-44C5-A5E7-BA5A79CB929E}")
public interface ISpStream extends ISpStreamFormat {
  // Methods:
    /**
     * @param ppStream Mandatory Holder<IStream> parameter.
     */

    @VTID(16)
    void getBaseStream(
      Holder<IStream> ppStream);


      /**
       */

      @VTID(18)
      void close();


      // Properties:
    }
