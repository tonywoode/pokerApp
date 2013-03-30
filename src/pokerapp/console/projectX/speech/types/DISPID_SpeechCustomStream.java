package pokerapp.console.projectX.speech.types;

import com4j.*;

/**
 */
public enum DISPID_SpeechCustomStream implements ComEnum {
  /**
   * <p>
   * The value of this constant is 100
   * </p>
   */
  DISPID_SCSBaseStream(100),
  ;

  private final int value;
  DISPID_SpeechCustomStream(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
