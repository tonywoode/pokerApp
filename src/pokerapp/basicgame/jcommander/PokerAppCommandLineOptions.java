package pokerapp.basicgame.jcommander;

import com.beust.jcommander.Parameter;

/**
 * Created by Tony on 10/05/14.
 */
public class PokerAppCommandLineOptions {

    @Parameter(names = "-name", description = "Player name", required=false)
    String name;

    @Parameter(names = "-difficulty", description = "Opponent difficulty", required=false, validateWith = DifficultyValidator.class)
    Integer difficulty;

    @Parameter(names = "-voice", description = "Voice activation", required=false)
    Boolean isVoiceActivated;
}
