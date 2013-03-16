package view;

import javax.swing.JFrame; 

/**
 * Launches the pokerapp gui
 * @author tony
 *
 */
public class GuiRunner
{ 
    public static void main(String[] args)
    {

        JFrame frame = new GuiFrame();
        frame.setTitle("Pokerapp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(true);
        frame.setResizable(false);

    }
} 