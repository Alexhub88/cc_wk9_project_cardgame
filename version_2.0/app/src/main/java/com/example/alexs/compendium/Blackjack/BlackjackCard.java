package com.example.alexs.compendium.Blackjack;

public class BlackjackCard {

    private Suit suit;
    private BlackjackRank rank;

    public BlackjackCard(Suit suit, BlackjackRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public BlackjackRank getRank() {
        return rank;
    }

    public int getValue(){
        return this.rank.getValue();
    }

    public String prettyName(){
        return (rank.getName() + " of " + suit.getSuit());
    }
}
