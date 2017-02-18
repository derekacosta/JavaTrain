package texas;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> cards;
	
	public Player(String name, ArrayList<Card> cards) {
		this.name = name;
		this.cards = new ArrayList<Card>(cards);
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
}

