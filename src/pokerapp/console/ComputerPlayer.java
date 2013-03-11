package pokerapp.console;

/**
 * Created with IntelliJ IDEA.
 * User: steve
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        setPlayerName(name);

    }

    public ComputerPlayer(){
        this("Computer");
    }

    //@Override
    // extract common bits of public void playTurn(IConsole console, Deck deck){


}
