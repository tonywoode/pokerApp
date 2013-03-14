package pokerapp.console;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ari
 * @version 1.0
 * @param //TODO:Parameter Description
 */
public class UserConfigurable {

  @Getter @Setter private int settingMax;
  @Getter @Setter private int settingMin;
  @Getter @Setter private int settingUser;
  @Getter @Setter private String settingMessage;

  private final String USER_INVALID_NUMBER = "User entered invalid setting.";
  private final String NOT_BETWEEN = "That's not between ";
  private final String BETTER_LUCK = " better luck next time!";

  UserConfigurable(String settingMessage, int settingMin, int settingMax){
    this.settingMin = settingMin;
    this.settingMax = settingMax;
    this.settingMessage = settingMessage;
  }

  public int askUser(IConsole console, boolean showRange) throws Exception{   //TODO:must be a better way than passing console explicitly

    console.writeMessage(settingMessage);

    if(showRange) console.writeMessage("Please enter " + settingMin + " to " + settingMax + ":\n");

    int settingValue = console.readInteger();

    if (settingValue > settingMax || settingValue < settingMin) {
      String errorMessage = NOT_BETWEEN + settingMin + " and " + settingMax + "," + BETTER_LUCK;
      console.writeMessage(errorMessage);
      throw new Exception(USER_INVALID_NUMBER);
    }


    return settingValue;
  }

}
