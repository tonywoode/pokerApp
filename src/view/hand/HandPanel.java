package view.hand;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import pokerapp.Card;
import pokerapp.Hand;
import pokerapp.Suit;
import view.ImageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public final class HandPanel extends JPanel {
	
	/**
	 * Displays cards in a panel
	 * @author tony
	 * @wbp.factory
	 */
	
	private final ArrayList<ImageView> imageViews = new ArrayList<>();
	private final ArrayList<CardViewModel> cards = new ArrayList<>();
	
	public HandPanel() {
		this.setLayout(new FlowLayout());
		
		final int MAX_CARDS = 7;

		for (int iter = 2; iter != MAX_CARDS; ++iter) {

		      Card card = new Card(Suit.Hearts, iter);
		      CardViewModel cardVM = CardViewModel.create(card);

		      ImageView imageView = new ImageView();
		      imageView.setImage(cardVM.getImage());

		      imageViews.add(imageView);
		      this.add(imageView);
		     
		}

	}
		
	public void setCards(Iterable<CardViewModel> cards) {
		int iter = 0;
		this.cards.clear();
		for (CardViewModel card : cards) {
			imageViews.get(iter++).setImage(card.getImage());
			this.cards.add(card);
		}
	}
		
}
