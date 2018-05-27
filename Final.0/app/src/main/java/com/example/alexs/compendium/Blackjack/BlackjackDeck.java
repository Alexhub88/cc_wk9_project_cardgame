package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;
import java.util.Collections;

//Essentially the same as for High Low Deck but uses BlackjackCards
public class BlackjackDeck {

    private ArrayList<BlackjackCard> cards;

    public BlackjackDeck() {
        cards = new ArrayList<>();
        generateDeck();
        shuffle();
    }

    public int getNumberOfCards(){
        return cards.size();
    }

// Creates an empty deck before the cards are dealt
    private void generateDeck(){
        for(Suit suit : Suit.values()){
            for(BlackjackRank rank : BlackjackRank.values()){
                cards.add(new BlackjackCard(suit, rank));
            }
        }
    }
// Randomly changes the order of the cards to simulate shuffling the deck
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public BlackjackCard getCard(){
        return cards.remove(0);
    }
}
