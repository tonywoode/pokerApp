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

public class PokerViewer {

	private JFrame frame;
	private JLabel txtPictureOfA;

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
		GridBagConstraints gbc_PlayersPanel = new GridBagConstraints();
		gbc_PlayersPanel.insets = new Insets(0, 0, 0, 5);
		gbc_PlayersPanel.fill = GridBagConstraints.BOTH;
		gbc_PlayersPanel.gridx = 0;
		gbc_PlayersPanel.gridy = 0;
		UpperThirdPanel.add(PlayersPanel, gbc_PlayersPanel);
		
		JButton btnNewButton_2 = new JButton("Lucky Luke");
		PlayersPanel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Jimmy");
		PlayersPanel.add(btnNewButton);
		
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
		txtPictureOfA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPictureOfA.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 8;
		gbc_btnExit.gridy = 0;
		UpperThirdPanel.add(btnExit, gbc_btnExit);
		
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
		gbl_panel_5.columnWidths = new int[]{304, 175, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{33, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel HandPanel = new JPanel();
		GridBagConstraints gbc_HandPanel = new GridBagConstraints();
		gbc_HandPanel.insets = new Insets(0, 0, 0, 5);
		gbc_HandPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_HandPanel.gridx = 1;
		gbc_HandPanel.gridy = 0;
		panel_5.add(HandPanel, gbc_HandPanel);
		
		JButton btnNewButton_3 = new JButton("Exchange");
		HandPanel.add(btnNewButton_3);
		
		JButton btnSomeAction = new JButton("Sort Hand");
		HandPanel.add(btnSomeAction);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		panel_5.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel TurnCompletePanel = new JPanel();
		GridBagConstraints gbc_TurnCompletePanel = new GridBagConstraints();
		gbc_TurnCompletePanel.fill = GridBagConstraints.BOTH;
		gbc_TurnCompletePanel.gridx = 3;
		gbc_TurnCompletePanel.gridy = 0;
		panel_5.add(TurnCompletePanel, gbc_TurnCompletePanel);
		
		JButton btnTurnComplete = new JButton("Turn Complete");
		TurnCompletePanel.add(btnTurnComplete);
		
		JPanel DeckPanel = new JPanel();
		DeckPanel.setBackground(new Color(255, 0, 0));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(UpperThirdPanel, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addComponent(LowerThirdPanel, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(DeckPanel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(UpperThirdPanel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(DeckPanel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(239)
					.addComponent(LowerThirdPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
