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
		label.setVisible(true);
		
		panel.setVisible(false);
	}

	@Override
	protected void endAnimation() {
		label.setVisible(false);
		panel.setVisible(true);
	}

}
