package pokerapp.console.projectX;

import lombok.RequiredArgsConstructor;

/**
 * Implements the SayWhat Text-to-Speech system for Macs.
 *
 * adapted from http://catsonkeyboards.blogspot.co.uk/2010/08/making-mac-speak-in-java.html
 *
 * @author Ari
 * @author Steve
 */
@RequiredArgsConstructor
public class MacSayWhat extends SayWhat {
  private final String voice;

  //original values were: pbas +18, rate +70
  private static void say(String phrase, String voice) {
    try {
      new ProcessBuilder("say", "-v", voice, "[[pbas +0]] [[rate +25]] " + phrase).start().waitFor();
    }
    catch(java.io.IOException io){} catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void agnesSays(String phrase){
    say(phrase, "Agnes");
  }

  public static void fredSays(String phrase){
    say(phrase, "Fred");
  }

  public static void ralphSays(String phrase){
    say(phrase, "Ralph");
  }

  public static void vickiSays(String phrase){
    say(phrase, "Vicki");
  }

  @Override
  public void sayWhat(String message) {
    say(message, voice);
  }
}
