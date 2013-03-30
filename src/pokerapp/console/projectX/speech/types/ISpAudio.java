package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpAudio Interface
 */
@IID("{C05C768F-FAE8-4EC2-8E07-338321C12452}")
public interface ISpAudio extends ISpStreamFormat {
  // Methods:
  /**
   * @param newState MandatorySPAUDIOSTATE parameter.
   * @param ullReserved Mandatory long parameter.
   */

  @VTID(15)
  void setState(
   SPAUDIOSTATE newState,
    long ullReserved);


        /**
         */

        @VTID(21)
        void eventHandle();


        /**
         * @return  Returns a value of type int
         */

        @VTID(22)
        int getVolumeLevel();


        /**
         * @param level Mandatory int parameter.
         */

        @VTID(23)
        void setVolumeLevel(
          int level);


        /**
         * @return  Returns a value of type int
         */

        @VTID(24)
        int getBufferNotifySize();


        /**
         * @param cbSize Mandatory int parameter.
         */

        @VTID(25)
        void setBufferNotifySize(
          int cbSize);


        // Properties:
      }
