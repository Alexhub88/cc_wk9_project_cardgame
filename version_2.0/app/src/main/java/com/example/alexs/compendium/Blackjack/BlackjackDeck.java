package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;
import java.util.Collections;

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

    private void generateDeck(){
        for(Suit suit : Suit.values()){
            for(BlackjackRank rank : BlackjackRank.values()){
                cards.add(new BlackjackCard(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public BlackjackCard getCard(){
        return cards.remove(0);
    }
}
