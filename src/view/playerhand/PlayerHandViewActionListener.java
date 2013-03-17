package view.playerhand;

/**
 * Holds actions that user has performed in GUI: hold and exchange. Passes them to presenter
 * @author Tony
 *
 */
public interface PlayerHandViewActionListener {
	
	void onHold();

	void onExchange();
}
