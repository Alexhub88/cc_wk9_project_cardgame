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

    public boolean getHasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

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
