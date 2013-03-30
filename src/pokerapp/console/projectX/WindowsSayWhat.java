package pokerapp.console.projectX;

import pokerapp.console.projectX.speech.types.ClassFactory;
import pokerapp.console.projectX.speech.types.ISpeechVoice;
import pokerapp.console.projectX.speech.types.SpeechVoiceSpeakFlags;

/**
 * <p>
 *   Uses JACOB on Windows to access the built-in TTS
 *   engine using COM Automation (IDispatch-based interfaces)
 * </p>
 *
 * @author Steve
 * @version 1
 */
public class WindowsSayWhat extends SayWhat {
  private final ISpeechVoice tts;
  private final String voice;

  public WindowsSayWhat(String voice) {
    this.tts = ClassFactory.createSpVoice();
    this.voice = voice;
  }

  public static void main(String[] args) {
    new WindowsSayWhat("Fred").sayWhat("Hey Ari! Live from windows!");
  }

  public void sayWhat(String message) {
    tts.speak(message, SpeechVoiceSpeakFlags.SVSFDefault);
  }
}
