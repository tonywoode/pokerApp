package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum SpeechVoiceSpeakFlags implements ComEnum {
  /**
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SVSFDefault(0),
  /**
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SVSFlagsAsync(1),
  /**
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SVSFPurgeBeforeSpeak(2),
  /**
   * <p>
   * The value of this constant is 4
   * </p>
   */
  SVSFIsFilename(4),
  /**
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SVSFIsXML(8),
  /**
   * <p>
   * The value of this constant is 16
   * </p>
   */
  SVSFIsNotXML(16),
  /**
   * <p>
   * The value of this constant is 32
   * </p>
   */
  SVSFPersistXML(32),
  /**
   * <p>
   * The value of this constant is 64
   * </p>
   */
  SVSFNLPSpeakPunc(64),
  /**
   * <p>
   * The value of this constant is 64
   * </p>
   */
  SVSFNLPMask(64),
  /**
   * <p>
   * The value of this constant is 127
   * </p>
   */
  SVSFVoiceMask(127),
  /**
   * <p>
   * The value of this constant is -128
   * </p>
   */
  SVSFUnusedFlags(-128),
  ;

  private final int value;
  SpeechVoiceSpeakFlags(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
