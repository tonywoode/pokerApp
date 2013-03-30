package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum SPRULESTATE implements ComEnum {
  /**
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SPRS_INACTIVE(0),
  /**
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SPRS_ACTIVE(1),
  /**
   * <p>
   * The value of this constant is 3
   * </p>
   */
  SPRS_ACTIVE_WITH_AUTO_PAUSE(3),
  ;

  private final int value;
  SPRULESTATE(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
