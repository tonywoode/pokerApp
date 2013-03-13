package pokerapp.console;

import pokerapp.Deck;

/**
 * Created with IntelliJ IDEA.
 * @author steve
 * Date: 22/02/13
 * Time: 19:53
 * To change this template use File | Settings | File Templates.
 */
public class InteractivePlayer extends Player {

  final String VALID_INPUT = "(([12345]\\s){0,2}[12345])|^$";
  final int MAXPOS = 5;


    public InteractivePlayer(String name){
    setPlayerName(name);
  }

  public InteractivePlayer() {
    this("");
  }

  public String getPlayerNameFromUser(IConsole console) {
    console.writeMessage("What's your name?");
    setPlayerName(console.readLine());
    return getPlayerName();
  }

  @Override
  public void playTurn(IConsole console, Deck deck) {

//    console.writeMessage("Your hand is: " + getHand().toUserString());
    console.writeMessage("Your hand is: " + getHand().toFancyUserString());
    console.writeMessage("You can change between 0 and 3 cards.");
    console.writeMessage("Write the position of each card you want to exchange, separated by spaces. Then press enter");


    String command = console.readString();

    while(!command.matches(VALID_INPUT) || !isUniquePos(command))
    {
        console.writeMessage("Please enter valid input. Then press enter");
        command = console.readString();
    }

    ExchangeCardsInterpreter interpreter = new ExchangeCardsInterpreter(command);
    interpreter.execute(getHand(), deck);

//    console.writeMessage("Your new hand is: " + getHand().toUserString());
    console.writeMessage("Your new hand is: " + getHand().toFancyUserString());
  }

  /* Designed using variant of the code suggested here: http://stackoverflow.com/questions/3951547/java-array-finding-duplicates
  */

    private boolean isUniquePos(String command)
    {
        if(command.matches(VALID_INPUT) && !command.isEmpty())
        {
            boolean[] bitmap = new boolean[MAXPOS+1];
            java.util.Arrays.fill(bitmap, false);
            for (String strPos : command.split(" ")) {
                int pos = Integer.parseInt(strPos);
                if (!bitmap[pos])
                    bitmap[pos] = true;
                else
                    return false;
            }
        }
        return true;
    }
}
