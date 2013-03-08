package pokerapp.console;

/**
 * Created with IntelliJ IDEA.
 * User: steve, tony
 * Date: 22/02/13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class Dealer {
  private Deck deck;
	
  public Dealer(Deck deck) {
    this.deck = deck;
  }
	
	
  public void dealCards(int numCards, Players players) {
    for (int iter = 0; iter < numCards; ++iter) {
      for (Player player : players) {
        player.receiveCard(deck.pop());
      }
    }
  }

}
