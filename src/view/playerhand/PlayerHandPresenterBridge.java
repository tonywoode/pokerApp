package view.playerhand;

import javax.swing.JComponent;

import view.hand.HandPanel;

public class PlayerHandPresenterBridge {

	PlayerHandPresenter handPresenter;
	
	public PlayerHandPresenterBridge(PlayerHandPresenter phPresenter) {
		handPresenter = phPresenter;
	}
	
	public JComponent getView() {
		return handPresenter.getView();	
	}
	
}
