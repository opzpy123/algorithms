package competeTest.orther.kaniu;

import java.util.Arrays;

public class Player {
	private Card[] cards;

	public Player() {
	}

	public Player(Card[] cards) {
		this.cards = cards;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "{" +
				"cards=" + Arrays.toString(cards) +
				'}';
	}
}
