package pokerapp.basicgame;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.console.ConsoleGame;

/**
 * Provides the main entry point to the console app,
 * but this implementation uses Spring for DI
 *
 * @author Steve
 * @version 1.0
 */
public class SpringGame {

  /**
   * Main entry point for the Spring-based DI version of the game
   *
   * @param args command line arguments; not currently used
   */
  public static void main(String[] args) {
    try {
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/console-game-application-context.xml");

      ConsoleGame game = (ConsoleGame) appContext.getBean("consoleGame");

      game.play();

    } catch (BeansException e) {
      System.out.println("Error:" + e.getMessage());
    }

    System.out.println("Exiting...");

  }

}
