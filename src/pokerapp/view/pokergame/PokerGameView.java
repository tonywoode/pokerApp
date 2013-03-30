package pokerapp.view.pokergame;

import pokerapp.view.MsgAnimation;
import pokerapp.view.ScoresPanel;
import pokerapp.view.StartButton;
import pokerapp.view.TextPanel;
import pokerapp.view.events.EventSource;
import pokerapp.view.playerhand.ComputerHandView;
import pokerapp.view.playerhand.PlayerHandPresenterBridge;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Frame for pokerapp with basic game view imp
 *
 * @author Tony
 *
 */

public class PokerGameView extends JFrame {
	final int FRAME_WIDTH = 912;
	final int FRAME_HEIGHT = 620;
	final String backGround = "pics/TableBack.png";
	final String logoFile = "pics/PokerappLogo.png";

	private Container container = null;
	private JPanel backPanel;
	private TextPanel textPanel;
	private StartButton startButton;
	private ScoresPanel scoresPanel;
	private JLabel logo;


	private JLabel drawLabel;
	private JLabel winLabel;
	private JLabel loseLabel;
	private JLabel startLabel;
	private JLabel playerLabel;
	private JLabel computerLabel;

	private final List<PokerGameViewActionListener> listeners = new ArrayList<PokerGameViewActionListener>();

	private final EventSource eventSource;

  private JButton hackButton = new JButton();

	public PokerGameView(EventSource eventSource) {
		this.eventSource = eventSource;
		initComponents();
		layoutComponents();
	}

	/**
	 * adds listeners
	 * @param listener
	 */
	public void addActionListener(PokerGameViewActionListener listener) {
		listeners.add(listener);
	}

	/**
	 * sets up views of the two players hands
	 * @param playerHandPresenterBridge the bridge to the imp of the hand presentation code
	 * @param computerHandView the rendering of the computers hand
	 */
	public void registerSubViews(final PlayerHandPresenterBridge playerHandPresenterBridge,
			final ComputerHandView computerHandView) {
		computerHandView.handPanelEnabler(false);
		JComponent cpuHandView = computerHandView.getView();
		cpuHandView.setOpaque(false);
		cpuHandView.setBounds(220, 70, 525, 105);	

		JComponent playerHandView = playerHandPresenterBridge.getView();
		playerHandView.setOpaque(false);
		playerHandView.setBounds(100, 420, 650, 105);

		backPanel.add(cpuHandView);
		backPanel.add(playerHandView);
	}

	protected void initComponents() {
		this.startButton = new StartButton();
		this.scoresPanel = new ScoresPanel();
		this.textPanel = new TextPanel();

    configureHackButton();
	}

  public class GuiHackEvent { }

  private void configureHackButton() {


    hackButton.setToolTipText("Start a Game");
    hackButton.setOpaque(false);
    hackButton.setText("Hack");
    hackButton.setBackground(new Color(34, 142, 34));
    hackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    hackButton.setBounds(712, 200, 106, 65);
    this.add(hackButton);

    hackButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        eventSource.fire(new GuiHackEvent());
      }
    });
  }

  /**
	 * draws the frame with background
	 * Poker Table Background adapted from thePokerBox.com
	 */
	protected void layoutComponents() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		container = getContentPane();
		container.setLayout(null);

		drawBackground();
		drawLogo();
		guiLabels();

		backPanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		backPanel.setLayout(null);

		startButton.setBounds(712, 255, 106, 65);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PokerGameViewActionListener listener : listeners)
					listener.startGame();
				eventSource.fire(new BeginGameEvent());
				MsgAnimation anim = new MsgAnimation(textPanel, startLabel);
				anim.begin(1000);
			}
		});

		scoresPanel.setBounds(57, 174, 208, 191);
		textPanel.setBounds(287, 245, 415, 129);

		container.add(backPanel);
		backPanel.add(logo);
		backPanel.add(scoresPanel);
		backPanel.add(textPanel);
		backPanel.add(startButton);
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
	private void guiLabels() {
		playerLabel = new JLabel();
		playerLabel.setIcon(new ImageIcon("pics/Player.png"));
		playerLabel.setBounds(650, 391, 127, 41);
		backPanel.add(playerLabel);

		computerLabel = new JLabel();
		computerLabel.setIcon(new ImageIcon("pics/Computer.png"));
		computerLabel.setBounds(643, 170, 106, 30);
		backPanel.add(computerLabel);

		drawLabel = new JLabel();
		drawLabel.setVisible(false);
		drawLabel.setIcon(new ImageIcon("pics/YouDraw.png"));
		drawLabel.setBounds(260, 211, 450, 154);
		backPanel.add(drawLabel);

		winLabel = new JLabel();
		winLabel.setVisible(false);
		winLabel.setIcon(new ImageIcon("pics/YouWin.png"));
		winLabel.setBounds(260, 211, 450, 154);
		backPanel.add(winLabel);

		loseLabel = new JLabel();
		loseLabel.setVisible(false);
		loseLabel.setIcon(new ImageIcon("pics/Youlose.png"));
		loseLabel.setBounds(260, 211, 450, 154);
		backPanel.add(loseLabel);

		startLabel = new JLabel();
		startLabel.setVisible(false);
		startLabel.setIcon(new ImageIcon("pics/LetsPlayPoker.png"));
		startLabel.setBounds(260, 211, 450, 154);
		backPanel.add(startLabel);
	}

	/**
	 * Display the appropriate message depending on round result
	 * @param winMessage win, lose or draw message
	 */
	public void showGameResultMessage(int winMessage) {
		switch (winMessage) {
		case 0:
			displayStatusMessage(drawLabel);
			break;
		case 1:
			displayStatusMessage(winLabel);
			break;
		case -1:
			displayStatusMessage(loseLabel);			
			break;
		default:				
		}
	}

	/**
	 * Renders the appropriate message on game result
	 * @param label win, lose or draw label
	 */
	private void displayStatusMessage(JLabel label) {
		MsgAnimation anim = new MsgAnimation(textPanel, label);
		anim.begin(1500);	
	}	

	/**
	 * renders message to text panel
	 * @param msg string to display
	 */
	public void displayMessage(String msg) {
		textPanel.setMessage(msg);
	}

	/**
	 * Enables or disables start button
	 * @param enable displays and is clickable when true
	 */
	public void startButtonEnable(boolean enable) {
		startButton.setEnabled(enable);
		startButton.setBorderPainted(enable);
	}

}