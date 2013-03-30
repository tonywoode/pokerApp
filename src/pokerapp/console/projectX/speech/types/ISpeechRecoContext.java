package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 * ISpeechRecoContext Interface
 */
@IID("{580AA49D-7E1E-4809-B8E2-57DA806104B8}")
public interface ISpeechRecoContext extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Recognizer
   * </p>
   * <p>
   * Getter method for the COM property "Recognizer"
   * </p>
   * @return  Returns a value of typeISpeechRecognizer
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
 ISpeechRecognizer recognizer();


  /**
   * <p>
   * AudioInInterferenceStatus
   * </p>
   * <p>
   * Getter method for the COM property "AudioInputInterferenceStatus"
   * </p>
   * @return  Returns a value of typeSpeechInterference
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
 SpeechInterference audioInputInterferenceStatus();


  /**
   * <p>
   * RequestedUIType
   * </p>
   * <p>
   * Getter method for the COM property "RequestedUIType"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  java.lang.String requestedUIType();


  /**
   * <p>
   * Voice
   * </p>
   * <p>
   * Setter method for the COM property "Voice"
   * </p>
   * @param voice MandatoryISpeechVoice parameter.
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  void voice(
   ISpeechVoice voice);


  /**
   * <p>
   * Voice
   * </p>
   * <p>
   * Getter method for the COM property "Voice"
   * </p>
   * @return  Returns a value of typeISpeechVoice
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(11)
 ISpeechVoice voice();


  /**
   * <p>
   * AllowVoiceFormatMatchingOnNextSet
   * </p>
   * <p>
   * Setter method for the COM property "AllowVoiceFormatMatchingOnNextSet"
   * </p>
   * @param pAllow Mandatory boolean parameter.
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(12)
  void allowVoiceFormatMatchingOnNextSet(
    boolean pAllow);


  /**
   * <p>
   * AllowVoiceFormatMatchingOnNextSet
   * </p>
   * <p>
   * Getter method for the COM property "AllowVoiceFormatMatchingOnNextSet"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(13)
  boolean allowVoiceFormatMatchingOnNextSet();


  /**
   * <p>
   * VoicePurgeEvent
   * </p>
   * <p>
   * Setter method for the COM property "VoicePurgeEvent"
   * </p>
   * @param eventInterest MandatorySpeechRecoEvents parameter.
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(14)
  void voicePurgeEvent(
   SpeechRecoEvents eventInterest);


  /**
   * <p>
   * VoicePurgeEvent
   * </p>
   * <p>
   * Getter method for the COM property "VoicePurgeEvent"
   * </p>
   * @return  Returns a value of typeSpeechRecoEvents
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(15)
 SpeechRecoEvents voicePurgeEvent();


  /**
   * <p>
   * EventInterests
   * </p>
   * <p>
   * Setter method for the COM property "EventInterests"
   * </p>
   * @param eventInterest MandatorySpeechRecoEvents parameter.
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(16)
  void eventInterests(
   SpeechRecoEvents eventInterest);


  /**
   * <p>
   * EventInterests
   * </p>
   * <p>
   * Getter method for the COM property "EventInterests"
   * </p>
   * @return  Returns a value of typeSpeechRecoEvents
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(17)
 SpeechRecoEvents eventInterests();


  /**
   * <p>
   * CmdMaxAlternates
   * </p>
   * <p>
   * Setter method for the COM property "CmdMaxAlternates"
   * </p>
   * @param maxAlternates Mandatory int parameter.
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(18)
  void cmdMaxAlternates(
    int maxAlternates);


  /**
   * <p>
   * CmdMaxAlternates
   * </p>
   * <p>
   * Getter method for the COM property "CmdMaxAlternates"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(19)
  int cmdMaxAlternates();


  /**
   * <p>
   * State
   * </p>
   * <p>
   * Setter method for the COM property "State"
   * </p>
   * @param state MandatorySpeechRecoContextState parameter.
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(20)
  void state(
   SpeechRecoContextState state);


  /**
   * <p>
   * State
   * </p>
   * <p>
   * Getter method for the COM property "State"
   * </p>
   * @return  Returns a value of typeSpeechRecoContextState
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(21)
 SpeechRecoContextState state();


  /**
   * <p>
   * RetainedAudio
   * </p>
   * <p>
   * Setter method for the COM property "RetainedAudio"
   * </p>
   * @param option MandatorySpeechRetainedAudioOptions parameter.
   */

  @DISPID(10) //= 0xa. The runtime will prefer the VTID if present
  @VTID(22)
  void retainedAudio(
   SpeechRetainedAudioOptions option);


  /**
   * <p>
   * RetainedAudio
   * </p>
   * <p>
   * Getter method for the COM property "RetainedAudio"
   * </p>
   * @return  Returns a value of typeSpeechRetainedAudioOptions
   */

  @DISPID(10) //= 0xa. The runtime will prefer the VTID if present
  @VTID(23)
 SpeechRetainedAudioOptions retainedAudio();


  /**
   * <p>
   * RetainedAudioFormat
   * </p>
   * <p>
   * Setter method for the COM property "RetainedAudioFormat"
   * </p>
   * @param format MandatoryISpeechAudioFormat parameter.
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(24)
  void retainedAudioFormat(
   ISpeechAudioFormat format);


  /**
   * <p>
   * RetainedAudioFormat
   * </p>
   * <p>
   * Getter method for the COM property "RetainedAudioFormat"
   * </p>
   * @return  Returns a value of typeISpeechAudioFormat
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(25)
 ISpeechAudioFormat retainedAudioFormat();


  /**
   * <p>
   * Pause
   * </p>
   */

  @DISPID(12) //= 0xc. The runtime will prefer the VTID if present
  @VTID(26)
  void pause();


  /**
   * <p>
   * Resume
   * </p>
   */

  @DISPID(13) //= 0xd. The runtime will prefer the VTID if present
  @VTID(27)
  void resume();


  /**
   * <p>
   * CreateGrammar
   * </p>
   * @param grammarId Optional parameter. Default value is 0
   * @return  Returns a value of typeISpeechRecoGrammar
   */

  @DISPID(14) //= 0xe. The runtime will prefer the VTID if present
  @VTID(28)
 ISpeechRecoGrammar createGrammar(
    @Optional @DefaultValue("0") @MarshalAs(NativeType.VARIANT) java.lang.Object grammarId);


  /**
   * <p>
   * CreateResultFromMemory
   * </p>
   * @param resultBlock Mandatory java.lang.Object parameter.
   * @return  Returns a value of typeISpeechRecoResult
   */

  @DISPID(15) //= 0xf. The runtime will prefer the VTID if present
  @VTID(29)
 ISpeechRecoResult createResultFromMemory(
    java.lang.Object resultBlock);


  /**
   * <p>
   * Bookmark
   * </p>
   * @param options MandatorySpeechBookmarkOptions parameter.
   * @param streamPos Mandatory java.lang.Object parameter.
   * @param bookmarkId Mandatory java.lang.Object parameter.
   */

  @DISPID(16) //= 0x10. The runtime will prefer the VTID if present
  @VTID(30)
  void bookmark(
   SpeechBookmarkOptions options,
    @MarshalAs(NativeType.VARIANT) java.lang.Object streamPos,
    @MarshalAs(NativeType.VARIANT) java.lang.Object bookmarkId);


  /**
   * <p>
   * SetAdaptationData
   * </p>
   * @param adaptationString Mandatory java.lang.String parameter.
   */

  @DISPID(17) //= 0x11. The runtime will prefer the VTID if present
  @VTID(31)
  void setAdaptationData(
    java.lang.String adaptationString);


  // Properties:
}
