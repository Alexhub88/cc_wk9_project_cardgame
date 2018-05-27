package com.example.alexs.compendium.HighLow;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private int value;

    public Hand() {
        this.cards = new ArrayList<Card>();
        value = 0;
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<Card>(this.cards);
    }

    public int getHandValue() {
        return this.value;
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

// Add a card to the hand

    public void addCard(Card card) {
        this.cards.add(card);
        this.value += card.getValue();
    }

// Reset the hand to begin a new game

    public void resetHand(){
        this.cards = new ArrayList<Card>();
        value = 0;
    }
}
