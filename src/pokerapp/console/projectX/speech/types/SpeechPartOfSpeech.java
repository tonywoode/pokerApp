package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum SpeechPartOfSpeech implements ComEnum {
  /**
   * <p>
   * The value of this constant is -1
   * </p>
   */
  SPSNotOverriden(-1),
  /**
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SPSUnknown(0),
  /**
   * <p>
   * The value of this constant is 4096
   * </p>
   */
  SPSNoun(4096),
  /**
   * <p>
   * The value of this constant is 8192
   * </p>
   */
  SPSVerb(8192),
  /**
   * <p>
   * The value of this constant is 12288
   * </p>
   */
  SPSModifier(12288),
  /**
   * <p>
   * The value of this constant is 16384
   * </p>
   */
  SPSFunction(16384),
  /**
   * <p>
   * The value of this constant is 20480
   * </p>
   */
  SPSInterjection(20480),
  ;

  private final int value;
  SpeechPartOfSpeech(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
