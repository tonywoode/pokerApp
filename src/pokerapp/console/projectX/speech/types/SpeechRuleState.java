package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum SpeechRuleState implements ComEnum {
  /**
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SGDSInactive(0),
  /**
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SGDSActive(1),
  /**
   * <p>
   * The value of this constant is 3
   * </p>
   */
  SGDSActiveWithAutoPause(3),
  ;

  private final int value;
  SpeechRuleState(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
