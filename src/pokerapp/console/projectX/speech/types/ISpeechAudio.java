package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechAudio Interface
 */
@IID("{CFF8E175-019E-11D3-A08E-00C04F8EF9B5}")
public interface ISpeechAudio extends ISpeechBaseStream {
  // Methods:
  /**
   * <p>
   * Status
   * </p>
   * <p>
   * Getter method for the COM property "Status"
   * </p>
   * @return  Returns a value of typeISpeechAudioStatus
   */

  @DISPID(200) //= 0xc8. The runtime will prefer the VTID if present
  @VTID(12)
 ISpeechAudioStatus status();


  /**
   * <p>
   * BufferInfo
   * </p>
   * <p>
   * Getter method for the COM property "BufferInfo"
   * </p>
   * @return  Returns a value of typeISpeechAudioBufferInfo
   */

  @DISPID(201) //= 0xc9. The runtime will prefer the VTID if present
  @VTID(13)
 ISpeechAudioBufferInfo bufferInfo();


  /**
   * <p>
   * DefaultFormat
   * </p>
   * <p>
   * Getter method for the COM property "DefaultFormat"
   * </p>
   * @return  Returns a value of typeISpeechAudioFormat
   */

  @DISPID(202) //= 0xca. The runtime will prefer the VTID if present
  @VTID(14)
 ISpeechAudioFormat defaultFormat();


  /**
   * <p>
   * Volume
   * </p>
   * <p>
   * Getter method for the COM property "Volume"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(203) //= 0xcb. The runtime will prefer the VTID if present
  @VTID(15)
  int volume();


  /**
   * <p>
   * Volume
   * </p>
   * <p>
   * Setter method for the COM property "Volume"
   * </p>
   * @param volume Mandatory int parameter.
   */

  @DISPID(203) //= 0xcb. The runtime will prefer the VTID if present
  @VTID(16)
  void volume(
    int volume);


  /**
   * <p>
   * BufferNotifySize
   * </p>
   * <p>
   * Getter method for the COM property "BufferNotifySize"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(204) //= 0xcc. The runtime will prefer the VTID if present
  @VTID(17)
  int bufferNotifySize();


  /**
   * <p>
   * BufferNotifySize
   * </p>
   * <p>
   * Setter method for the COM property "BufferNotifySize"
   * </p>
   * @param bufferNotifySize Mandatory int parameter.
   */

  @DISPID(204) //= 0xcc. The runtime will prefer the VTID if present
  @VTID(18)
  void bufferNotifySize(
    int bufferNotifySize);


  /**
   * <p>
   * EventHandle
   * </p>
   * <p>
   * Getter method for the COM property "EventHandle"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(205) //= 0xcd. The runtime will prefer the VTID if present
  @VTID(19)
  int eventHandle();


  /**
   * <p>
   * SetState
   * </p>
   * @param state MandatorySpeechAudioState parameter.
   */

  @DISPID(206) //= 0xce. The runtime will prefer the VTID if present
  @VTID(20)
  void setState(
   SpeechAudioState state);


  // Properties:
}
