package pokerapp.view.pokergame;

import pokerapp.console.projectX.SayWhat;
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
	
	private String verbalMsg;
	private JLabel visualMsg;

	private final List<PokerGameViewActionListener> listeners = new ArrayList<PokerGameViewActionListener>();

	private final EventSource eventSource;

	private final SayWhat sayWhat;

	/** private JButton hackButton = new JButton();*/

	public PokerGameView(EventSource eventSource, SayWhat sayWhat) {
		this.eventSource = eventSource;
		this.sayWhat = sayWhat;
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

		/*  configureHackButton();
	}

  public class GuiHackEvent { } //TODO:get rid of hackery!

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
    });*/
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
		playerLabel = new JLabel(new ImageIcon("pics/Player.png"));
		playerLabel.setBounds(623, 391, 127, 41);
		backPanel.add(playerLabel);

		computerLabel = new JLabel(new ImageIcon("pics/Computer.png"));
		computerLabel.setBounds(643, 170, 106, 30);
		backPanel.add(computerLabel);

		drawLabel = new JLabel(new ImageIcon("pics/YouDraw.png"));
		drawLabel.setVisible(false);
		drawLabel.setBounds(260, 211, 450, 154);
		backPanel.add(drawLabel);

		winLabel = new JLabel(new ImageIcon("pics/YouWin.png"));
		winLabel.setVisible(false);
		winLabel.setBounds(260, 211, 450, 154);
		backPanel.add(winLabel);

		loseLabel = new JLabel(new ImageIcon("pics/Youlose.png"));
		loseLabel.setVisible(false);
		loseLabel.setBounds(260, 211, 450, 154);
		backPanel.add(loseLabel);

		startLabel = new JLabel(new ImageIcon("pics/LetsPlayPoker.png"));
		startLabel.setVisible(false);
		startLabel.setBounds(260, 211, 450, 154);
		backPanel.add(startLabel);
	}

	/**
	 * Display the appropriate message depending on round result
	 * @param winMessage win, lose or draw message
	 */
	public synchronized void showGameResultMessage(int winMessage) {
		double random = Math.random();
		switch (winMessage) {
		case 0:
			verbalMsg = "OMG a draw!";
			visualMsg = drawLabel;
			threadingMessages();		
			break;
		case 1:
			visualMsg = winLabel;
			if (random <= 1.0 ) { verbalMsg = "Winner, winner, chicken dinner!"; }
			if (random < 0.8 ) { verbalMsg = "You won you did you won you did you won you did"; }
			if (random < 0.6 ) { verbalMsg = "You are the winner"; }
			if (random < 0.4 ) { verbalMsg = "Woop Woop Woop Woop"; }
			if (random < 0.2 ) { verbalMsg = "goodgame, good game"; }
			threadingMessages();
			break;
		case -1:
			visualMsg = loseLabel;
			if (random <= 1.0 ) { verbalMsg = "Your dreams in ruins"; }
			if (random < 0.8 ) { verbalMsg = "Shucks, lost, sucker"; }
			if (random < 0.6 ) { verbalMsg = "Looooser, Shmoooozer!"; }
			if (random < 0.4 ) { verbalMsg = "hey everybody look at the looooser"; }
			if (random < 0.2 ) { verbalMsg = "I'm sorry, Dave. I'm afraid I can't do that."; }
			threadingMessages();
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
		anim.begin(1000);	
	}	

	/**
	 * renders message to text panel
	 * @param msg string to display
	 */
	public synchronized void displayMessage(String msg){
		textPanel.setMessage(msg);
		sayWhat.sayWhat(msg);
	}

	/**
	 * Enables or disables start button
	 * @param enable displays and is clickable when true
	 */
	public void startButtonEnable(boolean enable) {
		startButton.setEnabled(enable);
		startButton.setBorderPainted(enable);
	}

	/**
	 * ensures onscreen popups and verbal messages happen simultaneously
	 * 
	 */
	public void threadingMessages() {
		new Thread(new Runnable() {
			public void run() {
				displayStatusMessage(visualMsg);
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				//sayWhat.sayWhat(verbalMsg); 
				displayMessage(verbalMsg);
			}
		}).start();
	}
}