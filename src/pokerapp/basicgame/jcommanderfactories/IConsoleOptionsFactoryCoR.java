package pokerapp.basicgame.jcommanderfactories;

import pokerapp.basicgame.jcommander.PokerAppCommandLineOptions;
import pokerapp.console.jcommandergame.PokerCommanderGame;

/**
 * Created by Tony on 10/05/14.
 */
public interface IConsoleOptionsFactoryCoR {
    public void create(PokerCommanderGame pokerGame, PokerAppCommandLineOptions pokerAppCommandLine);
    public void register(IConsoleOptionsFactoryCoR consoleOptionsFactoryCoR);
}
