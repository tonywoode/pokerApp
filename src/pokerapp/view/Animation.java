package pokerapp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Animate for image messages
 * @author Tony
 *
 */
public abstract class Animation  {

	public void begin(int duration) {
		beginAnimation();
		Timer timer = new Timer (duration, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endAnimation();
			};
		});
		timer.setRepeats(false);
		timer.start();
	}

	protected abstract void beginAnimation();

	protected abstract void endAnimation();
}
