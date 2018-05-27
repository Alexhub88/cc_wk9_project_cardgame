package com.example.alexs.compendium.HighLow;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        generateDeck();
        shuffle();
    }

    public int getNumberOfCards(){
        return cards.size();
    }

// Create a new deck at the start of the game

    private void generateDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

// Randomly shuffle the cards

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card getCard(){
        return cards.remove(0);
    }
}
