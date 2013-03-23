package pokerapp.view;

import javax.swing.JFrame; 

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Launches the pokerapp gui
 * @author tony
 *
 */
public class GUIRunner
{ 
	private GUIFrame guiFrame;
	
    public static void main(String[] args)
    {
    	try {
    	      ApplicationContext appContext = new ClassPathXmlApplicationContext("/pokerapp/view/gui-game-application-context.xml");
    	      //gets the bean, cast it to ConsoleGame, a Spring managed object
    	      GUIRunner game = (GUIRunner) appContext.getBean("guiGame");

    	      game.play();

    	    } catch (BeansException e) {
    	      System.out.println("Error:" + e.getMessage());
    	    }
    }
    
    public GUIRunner(GUIFrame guiFrame) {
    	this.guiFrame = guiFrame;
    }
    
    public void play() {
    	guiFrame.setTitle("Pokerapp");
    	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	guiFrame.setVisible(true);
    	guiFrame.setResizable(false);
    }
} 