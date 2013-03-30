package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechAudioStatus Interface
 */
@IID("{C62D9C91-7458-47F6-862D-1EF86FB0B278}")
public interface ISpeechAudioStatus extends Com4jObject {
  // Methods:
  /**
   * <p>
   * FreeBufferSpace
   * </p>
   * <p>
   * Getter method for the COM property "FreeBufferSpace"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  int freeBufferSpace();


  /**
   * <p>
   * NonBlockingIO
   * </p>
   * <p>
   * Getter method for the COM property "NonBlockingIO"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  int nonBlockingIO();


  /**
   * <p>
   * State
   * </p>
   * <p>
   * Getter method for the COM property "State"
   * </p>
   * @return  Returns a value of typeSpeechAudioState
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
 SpeechAudioState state();


  /**
   * <p>
   * CurrentSeekPosition
   * </p>
   * <p>
   * Getter method for the COM property "CurrentSeekPosition"
   * </p>
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object currentSeekPosition();


  /**
   * <p>
   * CurrentDevicePosition
   * </p>
   * <p>
   * Getter method for the COM property "CurrentDevicePosition"
   * </p>
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object currentDevicePosition();


  // Properties:
}
