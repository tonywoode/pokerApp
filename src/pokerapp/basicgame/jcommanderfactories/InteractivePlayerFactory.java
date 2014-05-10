package pokerapp.basicgame.jcommanderfactories;

import pokerapp.InteractivePlayer;

/**
 * Created by Tony on 10/05/14.
 */
public class InteractivePlayerFactory implements SettingsFactory {
    @Override
    public Object create() {
        return new InteractivePlayer();
    }
}
