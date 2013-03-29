package pokerapp.view.playerhand;

import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

/**
 * Holds actions that user has performed in GUI: hold and exchange. Passes them to presenter
 * @author Tony
 *
 */
public interface PlayerHandViewActionListener {
	
	void onHold() throws FormatStringException, IOException, IllegalFormatCodeException;

	void onExchange() throws IOException;
	

}
