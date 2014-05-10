package pokerapp.basicgame.jcommanderfactories;

import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.console.jcommandergame.PokerCommanderGame;

/**
 * Created by Tony on 10/05/14.
 */
public abstract class AbstractConsoleOptionFactoryCoR implements IConsoleOptionsFactoryCoR {

    IConsoleOptionsFactoryCoR nextFactory;

    public void create(PokerCommanderGame pokerCommanderGame, PokerAppCommandLineOptions pokerAppCommandLine) {
        if(nextFactory != null)
            nextFactory.create(pokerCommanderGame, pokerAppCommandLine);
        createConcrete(pokerCommanderGame, pokerAppCommandLine);
    }

    @Override
    public void register(IConsoleOptionsFactoryCoR consoleOptionsFactoryCoR) {
        this.nextFactory = consoleOptionsFactoryCoR;
    }

    protected abstract void createConcrete(PokerCommanderGame pokerCommanderGame, PokerAppCommandLineOptions pokerAppCommandLine);
}
