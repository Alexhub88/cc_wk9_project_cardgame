package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;

//Essentially the same as for High Low Hand but uses BlackjackRanks and Blackjack Cards
public class BlackjackHand {

    private ArrayList<BlackjackCard> cards;
    private int value;

    public BlackjackHand() {
        this.cards = new ArrayList<BlackjackCard>();
        value = 0;
    }

    public ArrayList<BlackjackCard> getCards() {
        return new ArrayList<BlackjackCard>(this.cards);
    }

    public int getHandValue() {
        return this.value;
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public void addCard(BlackjackCard card) {
        this.cards.add(card);
        this.value += card.getValue();
    }
}
