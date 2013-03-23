package pokerapp.view;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.view.pokergame.PokerGamePresenter;

/**
 * Main  entry point for GUI game
 * @author Tony
 * @author Steve 
 */

public class PokerGame {
  private final PokerGamePresenter pokerGamePresenter;

  public PokerGame(PokerGamePresenter pokerGamePresenter) {
    this.pokerGamePresenter = pokerGamePresenter;
  }

  public static void main(String[] args) {
    try {
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/pokerapp/view/gui-game-application-context.xml");
      //gets the bean, cast it to ConsoleGame, a Spring managed object
      PokerGame game = (PokerGame) appContext.getBean("pokerGame");

      game.pokerGamePresenter.play();

    } catch (BeansException e) {
      System.out.println("Error:" + e.getMessage());
    }
  }
}
