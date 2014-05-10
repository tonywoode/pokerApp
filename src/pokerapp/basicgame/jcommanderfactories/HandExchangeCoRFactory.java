package pokerapp.basicgame.jcommanderfactories;

import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.console.UserConfigurable;
import pokerapp.console.jcommandergame.PokerCommanderGame;

/**
 * Created by Tony on 10/05/14.
 */
public class HandExchangeCoRFactory extends AbstractConsoleOptionFactoryCoR {
    @Override
    protected void createConcrete(PokerCommanderGame pokerCommanderGame, PokerAppCommandLineOptions pokerAppCommandLine) {
        UserConfigurable userConfigurableCustomiseExchange = new UserConfigurable("Do you want to customise the way " +
                "exchanges work? (Yes = 1, No = 2)" + NEW_LINE, 1, 2);
        int customiseCardExchange = userConfigurableCustomiseExchange.askUser(console, false);

        switch (customiseCardExchange) {

            case 1:
                UserConfigurable userConfigurableNumCards = new UserConfigurable("How many cards do you want to exchange " +
                        "per hand?", MIN_CARDS_EXCHANGE, MAX_CARDS_EXCHANGE);
                cardsToExchange = userConfigurableNumCards.askUser(console, true);

                UserConfigurable userConfigurableNumHands = new UserConfigurable("How many hands do you want to exchange?"
                        + NEW_LINE, MIN_TIMES_EXCHANGE, MAX_TIMES_EXCHANGE);
                timesToExchange = userConfigurableNumHands.askUser(console, true);

                exchangeSetting.setNumCards(cardsToExchange);
                exchangeSetting.setNumTimes(timesToExchange);
                console.writeMessage("Excellent, you've decided to exchange " + cardsToExchange + " cards " +
                        timesToExchange + " times.", 1);
                break;

            case 2:
                console.writeMessage("No changes made.");     //default values already set
                break;
            default:

        }
        return numberOfPlayers;
    }
}
