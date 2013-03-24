package pokerapp.view;

import javax.swing.JLabel;
import pokerapp.view.TextPanel;

public class MsgAnimation extends Animation {
	
	private TextPanel panel;
	private JLabel label;
	
	public MsgAnimation(TextPanel tp, JLabel label) {
		this.panel = tp;
		this.label = label;
	}
	
	@Override
	protected void beginAnimation() {
		panel.setVisible(false);
		label.setVisible(true);
	}

	@Override
	protected void endAnimation() {
		label.setVisible(false);
		panel.setVisible(true);
	}

}
