package pokerapp.view.playerhand;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.utils.textformat.FormatStringException;
import pokerapp.utils.textformat.IllegalFormatCodeException;
import pokerapp.view.Displayable;
import pokerapp.view.ExchangeButton;
import pokerapp.view.HoldButton;
import pokerapp.view.hand.SuperHandPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * To collect together the displayable elements of the player in the game, so that the MVP pattern can communicate
 * most easily
 *
 * @author Tony
 */
public class PlayerHandView implements Displayable {

	// primary pokerapp.view for this part of the UI i.e., fits into a larger UI
	private JPanel mainView;
	private JPanel buttonsPanel = new JPanel();
	private SuperHandPanel handPanel;
	private ExchangeButton exchangeButton;
	private HoldButton holdButton;

	private List<PlayerHandViewActionListener> listeners = new ArrayList<>();
	private Component rigidArea;
	private Component rigidArea2;


	public PlayerHandView(SuperHandPanel handPanel) {
		this.handPanel = handPanel;
		initComponents();
		layoutComponents();
	}

	/**
	 * since PlayerHandView represents player in the GUI, the listeners will lie here for the pokerapp.view
	 * they will pass to the PlayerHandActionListener who will then pass onto the presenter
	 *
	 * @param listener
	 */
	public void addListener(PlayerHandViewActionListener listener) {
		listeners.add(listener);
	}

	public void setHand(Hand hand) throws FormatStringException, IOException, IllegalFormatCodeException {
		handPanel.setHand(hand);
	}

	public List<Card> getSelectedCards() {
		return handPanel.getSelectedCards();
	}

	private void initComponents() {
		this.mainView = new JPanel();
		mainView.setLayout(new BorderLayout());
		buttonsPanel.setOpaque(false);


		this.buttonsPanel.setLayout(new BoxLayout(this.buttonsPanel, BoxLayout.Y_AXIS));

		this.exchangeButton = new ExchangeButton();
		

		this.exchangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerHandViewActionListener listener : listeners) //here we pass event to the PHAL
          try {
            listener.onExchange();
          } catch (IOException e1) {
            // TODO: help!
          }
      }
		});

		this.holdButton = new HoldButton();
		holdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (PlayerHandViewActionListener listener : listeners) //here we pass event to the PHAL
          try {
            listener.onHold();
          } catch (IOException e1) {
            // TODO: help
          }
      }
		});

	}

	/**
	 * Puts the UI widgets in the right place
	 */
	private void layoutComponents() {

		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(30, 20));
		buttonsPanel.add(rigidArea);
		buttonsPanel.add(exchangeButton);

		rigidArea2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea2.setPreferredSize(new Dimension(50, 20));
		buttonsPanel.add(rigidArea2);
		buttonsPanel.add(holdButton);

		mainView.add(buttonsPanel, BorderLayout.WEST);
		mainView.add(handPanel);

	}

	@Override
	public JComponent getView() {
		return mainView;
	}

	public void userButtonsEnable(boolean enable) {
		exchangeButton.setEnabled(enable);
		exchangeButton.setBorderPainted(enable);
		holdButton.setEnabled(enable);
		holdButton.setBorderPainted(enable);
		handPanel.handPanelEnable(enable);
	}

}
