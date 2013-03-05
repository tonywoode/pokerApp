package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Viewer for GUI
 * @author Tony
 *
 */

public class PokerViewer {

	private JFrame frame;
	private JLabel txtPictureOfA;
	private JTextField txtSelectOpponent;
	private JTextField txtDeck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokerViewer window = new PokerViewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PokerViewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		
		JPanel UpperThirdPanel = new JPanel();
		GridBagLayout gbl_UpperThirdPanel = new GridBagLayout();
		gbl_UpperThirdPanel.columnWidths = new int[]{267, 179, 65, 0, 0, 0, 0, 0, 0, 0};
		gbl_UpperThirdPanel.rowHeights = new int[]{33, 0};
		gbl_UpperThirdPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_UpperThirdPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		UpperThirdPanel.setLayout(gbl_UpperThirdPanel);
		
		JPanel PlayersPanel = new JPanel();
		PlayersPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		GridBagConstraints gbc_PlayersPanel = new GridBagConstraints();
		gbc_PlayersPanel.insets = new Insets(0, 0, 0, 5);
		gbc_PlayersPanel.fill = GridBagConstraints.BOTH;
		gbc_PlayersPanel.gridx = 0;
		gbc_PlayersPanel.gridy = 0;
		UpperThirdPanel.add(PlayersPanel, gbc_PlayersPanel);
		
		txtSelectOpponent = new JTextField();
		txtSelectOpponent.setEditable(false);
		txtSelectOpponent.setBackground(new Color(220, 220, 220));
		txtSelectOpponent.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectOpponent.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSelectOpponent.setText("Select Opponent");
		PlayersPanel.add(txtSelectOpponent);
		txtSelectOpponent.setColumns(10);
		
		JButton btnNewButton1 = new JButton("Lucky Luke");
		PlayersPanel.add(btnNewButton1);
		
		JButton btnNewButton3 = new JButton("Jimmy");
		PlayersPanel.add(btnNewButton3);
		
		JButton btnNewButton_1 = new JButton("Pistorius");
		PlayersPanel.add(btnNewButton_1);
		
		JPanel PicturePanel = new JPanel();
		FlowLayout fl_PicturePanel = (FlowLayout) PicturePanel.getLayout();
		PicturePanel.setBackground(new Color(255, 165, 0));
		GridBagConstraints gbc_PicturePanel = new GridBagConstraints();
		gbc_PicturePanel.insets = new Insets(0, 0, 0, 5);
		gbc_PicturePanel.fill = GridBagConstraints.BOTH;
		gbc_PicturePanel.gridx = 1;
		gbc_PicturePanel.gridy = 0;
		UpperThirdPanel.add(PicturePanel, gbc_PicturePanel);
		
		txtPictureOfA = new JLabel();
		txtPictureOfA.setHorizontalAlignment(SwingConstants.CENTER);
		txtPictureOfA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPictureOfA.setText("Picture Of A Opponent");
		PicturePanel.add(txtPictureOfA);
		
		JPanel ExitPanel = new JPanel();
		FlowLayout fl_ExitPanel = (FlowLayout) ExitPanel.getLayout();
		fl_ExitPanel.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_ExitPanel = new GridBagConstraints();
		gbc_ExitPanel.weighty = 12.0;
		gbc_ExitPanel.weightx = 12.0;
		gbc_ExitPanel.insets = new Insets(100, 150, 0, 150);
		gbc_ExitPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_ExitPanel.gridx = 2;
		gbc_ExitPanel.gridy = 0;
		UpperThirdPanel.add(ExitPanel, gbc_ExitPanel);
		
		JPanel LowerThirdPanel = new JPanel();
		GridBagLayout gbl_LowerThirdPanel = new GridBagLayout();
		gbl_LowerThirdPanel.columnWidths = new int[]{0, 0};
		gbl_LowerThirdPanel.rowHeights = new int[]{0, 0};
		gbl_LowerThirdPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_LowerThirdPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		LowerThirdPanel.setLayout(gbl_LowerThirdPanel);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		LowerThirdPanel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{304, 0, 175, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{33, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel HandPanel = new JPanel();
		GridBagConstraints gbc_HandPanel = new GridBagConstraints();
		gbc_HandPanel.insets = new Insets(0, 0, 0, 5);
		gbc_HandPanel.anchor = GridBagConstraints.WEST;
		gbc_HandPanel.gridx = 0;
		gbc_HandPanel.gridy = 0;
		panel_5.add(HandPanel, gbc_HandPanel);
		
		JButton btnExchange = new JButton("Exchange");
		
		JButton btnSortHand = new JButton("Sort Hand");
		GroupLayout gl_HandPanel = new GroupLayout(HandPanel);
		gl_HandPanel.setHorizontalGroup(
			gl_HandPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_HandPanel.createSequentialGroup()
					.addComponent(btnExchange)
					.addComponent(btnSortHand))
		);
		gl_HandPanel.setVerticalGroup(
			gl_HandPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnExchange)
				.addComponent(btnSortHand)
		);
		HandPanel.setLayout(gl_HandPanel);
		
		JPanel Cardspanel = new JPanel();
		GridBagConstraints gbc_Cardspanel = new GridBagConstraints();
		gbc_Cardspanel.gridwidth = 6;
		gbc_Cardspanel.insets = new Insets(0, 0, 0, 5);
		gbc_Cardspanel.fill = GridBagConstraints.BOTH;
		gbc_Cardspanel.gridx = 1;
		gbc_Cardspanel.gridy = 0;
		panel_5.add(Cardspanel, gbc_Cardspanel);
		Cardspanel.setLayout(new BoxLayout(Cardspanel, BoxLayout.X_AXIS));
		
		//yes I know this should be a factory and not in the main class
		JPanel Card1panel = new JPanel();
		Card1panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card1panel.setBackground(Color.BLUE);
		Cardspanel.add(Card1panel);
		
		JPanel Card2panel = new JPanel();
		Card2panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card2panel.setBackground(Color.BLUE);
		Cardspanel.add(Card2panel);
		
		JPanel Card3panel = new JPanel();
		Card3panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card3panel.setBackground(Color.BLUE);
		Cardspanel.add(Card3panel);
		
		JPanel Card4panel = new JPanel();
		Card4panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card4panel.setBackground(Color.BLUE);
		Cardspanel.add(Card4panel);
		
		JPanel Card5panel = new JPanel();
		Card5panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card5panel.setBackground(Color.BLUE);
		Cardspanel.add(Card5panel);
		
		JPanel Card6panel = new JPanel();
		Card6panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		Card6panel.setBackground(Color.BLUE);
		Cardspanel.add(Card6panel);
		
		JPanel TurnCompletePanel = new JPanel();
		GridBagConstraints gbc_TurnCompletePanel = new GridBagConstraints();
		gbc_TurnCompletePanel.fill = GridBagConstraints.BOTH;
		gbc_TurnCompletePanel.gridx = 9;
		gbc_TurnCompletePanel.gridy = 0;
		panel_5.add(TurnCompletePanel, gbc_TurnCompletePanel);
		
		JButton btnTurnComplete = new JButton("Turn Complete");
		TurnCompletePanel.add(btnTurnComplete);
		
		JPanel DeckPanel = new JPanel();
		DeckPanel.setBackground(new Color(255, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(DeckPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addComponent(LowerThirdPanel, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
				.addComponent(UpperThirdPanel, GroupLayout.PREFERRED_SIZE, 792, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(UpperThirdPanel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(DeckPanel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(239)
					.addComponent(LowerThirdPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 7;
		gbc_btnExit.gridy = 0;
		UpperThirdPanel.add(btnExit, gbc_btnExit);
		
		txtDeck = new JTextField();
		txtDeck.setEditable(false);
		txtDeck.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDeck.setText("Deck");
		DeckPanel.add(txtDeck);
		txtDeck.setColumns(10);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
