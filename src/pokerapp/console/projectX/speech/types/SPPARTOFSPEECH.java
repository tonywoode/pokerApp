package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum SPPARTOFSPEECH implements ComEnum {
  /**
   * <p>
   * The value of this constant is -1
   * </p>
   */
  SPPS_NotOverriden(-1),
  /**
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SPPS_Unknown(0),
  /**
   * <p>
   * The value of this constant is 4096
   * </p>
   */
  SPPS_Noun(4096),
  /**
   * <p>
   * The value of this constant is 8192
   * </p>
   */
  SPPS_Verb(8192),
  /**
   * <p>
   * The value of this constant is 12288
   * </p>
   */
  SPPS_Modifier(12288),
  /**
   * <p>
   * The value of this constant is 16384
   * </p>
   */
  SPPS_Function(16384),
  /**
   * <p>
   * The value of this constant is 20480
   * </p>
   */
  SPPS_Interjection(20480),
  ;

  private final int value;
  SPPARTOFSPEECH(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
