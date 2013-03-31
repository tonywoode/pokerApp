package pokerapp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

import java.io.IOException;

/**
 * Provides a base class for spring-initialised application
 * entry points.
 *
 * @author Steve
 * @version 1
 */
public abstract class Application {

  /**
   *
   * @param name The name of the initial bean to get from spring
   * @param springConfig The spring config file to load
   * @throws IOException
   */
  public static void begin(String name, String springConfig) throws IOException {
    try {
      ApplicationContext appContext = new ClassPathXmlApplicationContext("/" + springConfig);
      ((Application) appContext.getBean(name)).run();
    } catch (BeansException e) {
      System.out.println("Error:" + e.getMessage());
    } catch (FormatStringException e) {
      e.printStackTrace();
    } catch (IllegalFormatCodeException e) {
      e.printStackTrace();
    }

    System.out.println("Exiting...");
  }

  /**
   * The main entry point for the application, after the object
   * has had its dependencies injected.
   *
   * @throws FormatStringException
   * @throws IllegalFormatCodeException
   * @throws IOException
   */
  public abstract void run() throws FormatStringException, IllegalFormatCodeException, IOException;
}
