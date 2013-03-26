package pokerapp.view;

import javax.swing.JLabel;
import pokerapp.view.TextPanel;

/**
 * Actions for the animation of to-screen message images vs.text in pokerapp.
 * Used because the images share the same space as the text panel
 * @author Tony
 *
 */
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
