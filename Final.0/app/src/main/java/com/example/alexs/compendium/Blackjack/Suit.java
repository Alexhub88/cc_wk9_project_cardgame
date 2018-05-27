package com.example.alexs.compendium.Blackjack;

// An enum to hold the Suits for each BlackjackCard object

public enum Suit {

    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
