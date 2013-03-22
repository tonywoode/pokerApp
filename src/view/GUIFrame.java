package view;

import pokerapp.Dealer;
import pokerapp.Hand;
import pokerapp.console.InteractivePlayer;
import pokerapp.console.Players;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import view.hand.SuperHandPanel;
import view.playerhand.PlayerHandPresenterBridge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Frame for pokerapp drawing background
 *
 * @author Tony
 * @author Steve
 */
public class GUIFrame extends JFrame {

  final int FRAME_WIDTH = 912;
  final int FRAME_HEIGHT = 620;
  final String backGround = "pics/TableBack3.png";
  final String logoFile = "pics/PokerappLogo.png";

  private Container container = null;
  private JPanel backPanel;
  private StartButton startButton;
  private ScoresPanel scoresPanel;
  private JLabel logo;

  private final Dealer dealer;

  /**
   * draws the frame with background
   * Poker Table Background adapted from thePokerBox.com
   */
  public GUIFrame(PlayerHandPresenterBridge playerHandPresenterBridge, SuperHandPanel computerHandPanel, Dealer dealer)
      throws FormatStringException, IOException, IllegalFormatCodeException {

    this.dealer = dealer;

    this.startButton = new StartButton();
    this.scoresPanel = new ScoresPanel();

    playerHandPresenterBridge.playRandomHand();
    computerHandPanel.setHand(getHand());

    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    container = getContentPane();
    container.setLayout(null);

    drawBackground();
    drawLogo();
    playerLabels();


    backPanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    backPanel.setLayout(null);

    startButton.setBounds(700, 300, 106, 65);
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Start command activated");
      }
    });

    scoresPanel.setBounds(57, 174, 208, 191);


    //setSize(backIcon.getIconWidth() + 5, backIcon.getIconHeight() + 25);
    //JPanel Cardpanel1 = new HandPanel();
    //Cardpanel1.setBounds(270, 70, 390, 105);
    /**JPanel Cardpanel2 = new HandPanel();
     Cardpanel2.setBounds(270, 430, 390, 105); */

    JComponent cpuHandView = computerHandPanel; // TODO: chp is a view - fix this
    cpuHandView.setOpaque(false);
    cpuHandView.setBounds(270, 70, 390, 105);


    JComponent playerHandView = playerHandPresenterBridge.getView();
    playerHandView.setOpaque(false);
    playerHandView.setBounds(145, 420, 515, 105);


    //backPanel.add(Cardpanel2);
    //backPanel.add(Cardpanel1);
    container.add(backPanel);
    backPanel.add(logo);
    backPanel.add(scoresPanel);
    backPanel.add(cpuHandView);
    backPanel.add(playerHandView);
    backPanel.add(startButton);


  }


  // temp...
  private Hand getHand() {
    InteractivePlayer ip = new InteractivePlayer();
    Players players = new Players().register(ip);

    dealer.dealCards(5, players);

    return ip.getHand();
  }

  /**
   * Sets the background image in the GUI Frame
   */
  private void drawBackground() {
    backPanel = new JPanel() {
      public void paintComponent(Graphics g) {
        Image backImage = new ImageIcon(backGround).getImage();
        Dimension size = new Dimension(backImage.getWidth(null), backImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        getContentPane().setLayout(null);
        g.drawImage(backImage, 0, 0, null);
      }
    };
  }

  /**
   * Draws the logo into the GUI Frame
   */
  private void drawLogo() {
    logo = new JLabel();
    logo.setBounds(10, 11, 305, 129);
    logo.setIcon(new ImageIcon(logoFile));
  }


  /**
   * Draws the labels for the computer and the player by the right of their cards
   */
  private void playerLabels() {
    JLabel playerLabel = new JLabel();
    playerLabel.setIcon(new ImageIcon("pics/Player.png"));
    playerLabel.setBounds(663, 414, 127, 41);
    backPanel.add(playerLabel);

    JLabel computerLabel = new JLabel();
    computerLabel.setIcon(new ImageIcon("pics/Computer.png"));
    computerLabel.setBounds(663, 70, 106, 30);
    backPanel.add(computerLabel);
  }


}   