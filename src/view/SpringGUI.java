package view;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.GUIRunner;

/**
 * Provides the main entry point to the console app,
 * but this implementation uses Spring for DI
 *
 * @author Tony
 * @version 1.0
 */
public class SpringGUI {

  /**
   * Main entry point for the Spring-based GUI version of the game
   *
   * @param args command line arguments; not currently used
   */
  public static void main(String[] args) {
    try {
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/view/GUI-game-application-context.xml");
      //gets the bean, cast it to GUIGame, a Spring managed object
      GUIRunner game = (GUIRunner) appContext.getBean("guiGame");

      game.main(args);

    } catch (BeansException e) {
      System.out.println("Error:" + e.getMessage());
    }

    System.out.println("Exiting...");

  }

}
