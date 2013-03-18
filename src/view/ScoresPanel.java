package view;

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
 * Panel for GUI which displays scores
 * @author tony
 *
 */

public class ScoresPanel extends JPanel {
	
	private JLabel scoresLabel;
	private JLabel cpuLabel;
	private JLabel YouLabel;
	private JTextField cpuScore;
	private JTextField youScore;

	public ScoresPanel() {
	
	
	this.setOpaque(false);
	scoresLabel = new JLabel();
	scoresLabel.setIcon(new ImageIcon("pics/Scores.png"));
	cpuLabel = new JLabel();
	cpuLabel.setIcon(new ImageIcon("pics/CPU.png"));
	YouLabel = new JLabel();
	YouLabel.setIcon(new ImageIcon("pics/You.png"));
	cpuScore = new JTextField();
	cpuScore.setEditable(false);
	cpuScore.setBorder(null);
	cpuScore.setHorizontalAlignment(SwingConstants.CENTER);
	cpuScore.setForeground(Color.WHITE);
	cpuScore.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
	cpuScore.setSelectedTextColor(Color.WHITE);
	cpuScore.setBackground(Color.DARK_GRAY);
	cpuScore.setText("1");
	cpuScore.setColumns(10);
	youScore = new JTextField();
	youScore.setEditable(false);
	youScore.setBorder(null);
	youScore.setHorizontalAlignment(SwingConstants.CENTER);
	youScore.setForeground(Color.WHITE);
	youScore.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
	youScore.setSelectedTextColor(Color.WHITE);
	youScore.setBackground(Color.DARK_GRAY);
	youScore.setText("5");
	youScore.setColumns(10);
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
	}

}
