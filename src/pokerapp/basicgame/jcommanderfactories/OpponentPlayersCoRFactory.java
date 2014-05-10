package pokerapp.basicgame.jcommanderfactories;

import pokerapp.ComputerPlayer;
import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.console.UserConfigurable;
import pokerapp.console.jcommandergame.PokerCommanderGame;

/**
 * Created by Tony on 10/05/14.
 */
public class OpponentPlayersCoRFactory extends AbstractConsoleOptionFactoryCoR {
    @Override
    protected void createConcrete(PokerCommanderGame pokerCommanderGame, PokerAppCommandLineOptions pokerAppCommandLine) {

        UserConfigurable userConfigurableNumPlayers =
                new UserConfigurable("How many computer players do you want to play against?" + NEW_LINE, MIN_NUMBER_PLAYERS, MAX_NUMBER_PLAYERS);
        int numberOfPlayers;
        int cardsToExchange;
        int timesToExchange;
        numberOfPlayers = userConfigurableNumPlayers.askUser(console, true);

        console.writeMessage("Who do you want to play against?");

        int index = 1;
        for (ComputerPlayer cp : computerPlayerFactory.getPlayers()) {
            console.writeMessage("{0}.\t{1} - ({2})", index++, cp.getPlayerName(), cp.getStrategyFancyName());
        }

        for (int i = MIN_NUMBER_PLAYERS; i <= numberOfPlayers; ++i) {
            console.writeMessage("Enter your opponent's number: ");
            int cpNumber = console.readInteger();

            ComputerPlayer cp = computerPlayerFactory.create(cpNumber - 1);
            players.register(cp);
        }
    }

}
}
