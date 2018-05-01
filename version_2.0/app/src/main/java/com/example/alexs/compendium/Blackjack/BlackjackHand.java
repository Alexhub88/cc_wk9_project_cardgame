package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;

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
