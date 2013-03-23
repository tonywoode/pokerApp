package pokerapp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;

/**
 * <p>
 * Detailed explanation of the class and its collaborators.
 * </p>
 * <p>
 * Describe whether the class uses/is part of a pattern.
 * </p>
 * <p>
 * Examples of use, if particularly complex
 * </p>
 *
 * @author Steve
 * @version 1
 */
public abstract class Application {

  public static void begin(String name, String springConfig) {
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

  public abstract void run() throws FormatStringException, IllegalFormatCodeException;
}
