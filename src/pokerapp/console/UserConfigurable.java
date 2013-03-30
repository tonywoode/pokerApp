package pokerapp.console;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ari
 * @version 1.0
 */
public class UserConfigurable {

  @Getter @Setter private int settingMax;
  @Getter @Setter private int settingMin;
  @Getter @Setter private int settingUser;
  @Getter @Setter private String settingMessage;

  public UserConfigurable(String settingMessage, int settingMin, int settingMax){
    this.settingMin = settingMin;
    this.settingMax = settingMax;
    this.settingMessage = settingMessage;
  }

  public int askUser(Console console, boolean showRange) {

    console.writeMessage(settingMessage);

    if(showRange) console.writeMessage("Please enter " + settingMin + " to " + settingMax + ":\n");

    int settingValue = console.readInteger();

    if (settingValue > settingMax || settingValue < settingMin) {
      String NOT_BETWEEN = "That's not between ";
      String BETTER_LUCK = " better luck next time!";
      String errorMessage = NOT_BETWEEN + settingMin + " and " + settingMax + "," + BETTER_LUCK;
      console.writeMessage(errorMessage);
      return(askUser(console, showRange));

    }

    return settingValue;
  }

}
