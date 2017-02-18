package texas;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;
	// Hint: You may find that preprocessing the cards to group them by rank is helpful.
	// Hint: Also, feel free to add more auxiliary variables here.

	public Hand(ArrayList<Card> cards) {
		setCards(cards);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = new ArrayList<Card>(cards);
	}

	public boolean isPair() {
		return false;
	}
	
	public boolean isTwoPairs() {
		return false;
	}
	
	public boolean isThreeofKind() {
		return false;		
	}

	public boolean isStraight() {
		return false;
	}

	public boolean isFullHouse() {
		return false;
	}

	public boolean isFourofKind() {
		return false;		
	}
	
	public int compareTo(Hand hand) {
		return 0;
	}
}
