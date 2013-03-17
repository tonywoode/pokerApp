package view.computerhand;

import javax.swing.JComponent;

import view.hand.HandPanel;

public class ComputerHandPresenterBridge {

	ComputerHandPresenter handPresenter;
	
	public ComputerHandPresenterBridge(ComputerHandPresenter cpuPresenter) {
		handPresenter = cpuPresenter;
	}
	
	public JComponent getView() {
		return handPresenter.getView();	
	}
	
}
