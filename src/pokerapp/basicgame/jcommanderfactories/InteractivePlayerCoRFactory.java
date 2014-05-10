package pokerapp.basicgame.jcommanderfactories;

import pokerapp.InteractivePlayer;
import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.console.jcommandergame.PokerCommanderGame;

/**
 * Created by Tony on 10/05/14.
 */
public class InteractivePlayerCoRFactory extends  AbstractConsoleOptionFactoryCoR {

    private final InteractivePlayerFactory interactivePlayerFactory;

    InteractivePlayerCoRFactory(InteractivePlayerFactory interactivePlayerFactory) {
        this.interactivePlayerFactory = interactivePlayerFactory;
    }

    @Override
    public void createConcrete(PokerCommanderGame pokerGame, PokerAppCommandLineOptions pokerAppCommandLine) {
        InteractivePlayer interactivePlayer = (InteractivePlayer) interactivePlayerFactory.create();
        interactivePlayer.setPlayerName(pokerAppCommandLine.getName());
        pokerGame.registerPlayer(interactivePlayer);
    }
}
