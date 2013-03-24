package pokerapp.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * Panel for GUI which displays players scores. Logic for scores will be elsewhere
 * @author tony
 *
 */

public class ScoresPanel extends JPanel {

	private JLabel scoresLabel;
	private JLabel cpuLabel;
	private JLabel YouLabel;
	private static JTextField cpuScore;
	private static JTextField youScore;
	
	
	
	public ScoresPanel() {

		scoresLabel = new JLabel();
		cpuLabel = new JLabel();
		YouLabel = new JLabel();

		//buttons
		scoresLabel.setIcon(new ImageIcon("pics/Scores.png"));
		cpuLabel.setIcon(new ImageIcon("pics/CPU.png"));
		YouLabel.setIcon(new ImageIcon("pics/You.png"));


		cpuScore = new JTextField();
		textFieldFormatBuilder(cpuScore);

		youScore = new JTextField();
		textFieldFormatBuilder(youScore);




		//group layout for scores panel
		GroupLayout gl_scoresPanel = new GroupLayout(this);
		gl_scoresPanel.setHorizontalGroup(
				gl_scoresPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoresPanel.createSequentialGroup()
						.addGroup(gl_scoresPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_scoresPanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_scoresPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(cpuLabel)
												.addComponent(cpuScore, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
												.addGap(73)
												.addGroup(gl_scoresPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(YouLabel)
														.addComponent(youScore, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_scoresPanel.createSequentialGroup()
																.addGap(40)
																.addComponent(scoresLabel)))
																.addContainerGap(141, Short.MAX_VALUE))
				);
		gl_scoresPanel.setVerticalGroup(
				gl_scoresPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoresPanel.createSequentialGroup()
						.addGap(35)
						.addComponent(scoresLabel)
						.addGap(18)
						.addGroup(gl_scoresPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(YouLabel)
								.addComponent(cpuLabel))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_scoresPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cpuScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(youScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(29, Short.MAX_VALUE))
				);
		this.setLayout(gl_scoresPanel);
		this.setOpaque(false);
	}


	/**
	 * formats the score fields with builder pattern 
	 * @param textField the text fields you want to format
	 */
	private void textFieldFormatBuilder (JTextField textField) {
		new JTextField();
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont( new Font("Showcard Gothic", Font.PLAIN, 16) );
		textField.setSelectedTextColor(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
	}

	
	public static void setScores(int cpuTally, int youTally) {
		cpuScore.setText(Integer.toString(cpuTally));
		youScore.setText(Integer.toString(youTally));
	}
	

}
