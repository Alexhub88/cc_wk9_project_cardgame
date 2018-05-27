package com.example.alexs.compendium.Blackjack;

public class BlackjackPlayer {

    private String name;
    private BlackjackHand hand;
    private boolean isPlayerActive;
    private boolean hasBlackjack;


    public BlackjackPlayer(String name, BlackjackHand hand, boolean isPlayerActive, boolean hasBlackjack) {
        this.name = name;
        this.hand = hand;
        this.isPlayerActive = isPlayerActive;
        this.hasBlackjack = false;
    }

    public String getName() {
        return name;
    }

    public BlackjackHand getHand() {
        return hand;
    }

    public boolean getIsPlayerActive() {
        return isPlayerActive;
    }

// Create getter method to discover if player has Blackjack

    public boolean getHasBlackjack() {
        return hasBlackjack;
    }

// Create setter method to set the indicator to show a player has Blackjack

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

// Setter method to show if a player's turn is over

    public void setIsPlayerActive(boolean activeStatus){
        isPlayerActive = activeStatus;
    }

    public int getHandValue() {
        return this.hand.getHandValue();
    }

    public void addCardToHand(BlackjackCard card) {
        this.hand.addCard(card);
    }

}
