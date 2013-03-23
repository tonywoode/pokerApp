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
 *
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
	private TextPanel textPanel;
	
	private JLabel drawLabel;
	private JLabel winLabel;
	private JLabel loseLabel;
	private JLabel startLabel;

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
		this.textPanel = new TextPanel();

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

		startButton.setBounds(712, 255, 106, 65);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Start command activated");
			}
		});

		scoresPanel.setBounds(57, 174, 208, 191);
		textPanel.setBounds(287, 236, 415, 129);


		JComponent cpuHandView = computerHandPanel; // TODO: chp is a view - fix this
		cpuHandView.setOpaque(false);
		cpuHandView.setBounds(270, 70, 390, 105);


		JComponent playerHandView = playerHandPresenterBridge.getView();
		playerHandView.setOpaque(false);
		playerHandView.setBounds(145, 420, 515, 105);

		container.add(backPanel);
		backPanel.add(logo);
		backPanel.add(scoresPanel);
		backPanel.add(textPanel);
		backPanel.add(cpuHandView);
		backPanel.add(playerHandView);
		backPanel.add(startButton);


		//TODO: just example labels delete them after implementing

		drawLabel = new JLabel("");
		drawLabel.setVisible(false);
		drawLabel.setIcon(new ImageIcon("pics/YouDraw.png"));
		drawLabel.setBounds(260, 211, 450, 154);
		backPanel.add(drawLabel);
		
		winLabel = new JLabel("");
		winLabel.setVisible(false);
		winLabel.setIcon(new ImageIcon("pics/YouWin.png"));
		winLabel.setBounds(260, 211, 450, 154);
		backPanel.add(winLabel);


		loseLabel = new JLabel("");
		loseLabel.setVisible(false);
		loseLabel.setIcon(new ImageIcon("pics/Youlose.png"));
		loseLabel.setBounds(260, 211, 450, 154);
		backPanel.add(loseLabel);
		
		
		startLabel = new JLabel("");
		startLabel.setVisible(false);
		startLabel.setIcon(new ImageIcon("pics/LetsPlayPoker.png"));
		startLabel.setBounds(290, 211, 450, 154);
		backPanel.add(startLabel);
		
		
		
		
		JButton buttonWin = new JButton("Win");
		buttonWin.setBounds(792, 37, 89, 23);
		backPanel.add(buttonWin);
		buttonWin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				winLabel.setVisible(true);
				textPanel.setVisible(false);
			}
		});

		JButton buttonLose = new JButton("Lose");
		buttonLose.setBounds(792, 70, 89, 23);
		backPanel.add(buttonLose);	
		buttonLose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loseLabel.setVisible(true);
				textPanel.setVisible(false);
			}
		});

		JButton buttonDraw = new JButton("Draw");
		buttonDraw.setBounds(792, 104, 89, 23);
		backPanel.add(buttonDraw);	
		backPanel.add(drawLabel);
		buttonDraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawLabel.setVisible(true);
				textPanel.setVisible(false);
			}
		});
	
	
		JButton buttonStart = new JButton("Start");
		buttonStart.setBounds(792, 134, 89, 23);
		backPanel.add(buttonStart);	
		backPanel.add(startLabel);
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startLabel.setVisible(true);
				textPanel.setVisible(false);
			}
		});
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