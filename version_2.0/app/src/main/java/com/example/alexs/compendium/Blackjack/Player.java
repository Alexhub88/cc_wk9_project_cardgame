package com.example.alexs.compendium.Blackjack;

import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexs.compendium.HighLow.Card;
import com.example.alexs.compendium.HighLow.Hand;
import com.example.alexs.compendium.R;

public class Player {

    private String name;
    private Hand hand;
    private boolean isPlayerActive;


    public Player(String name, Hand hand, boolean isPlayerActive) {
        this.name = name;
        this.hand = hand;
        this.isPlayerActive = isPlayerActive;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean getIsPlayerActive() {
        return isPlayerActive;
    }

    public void setIsPlayerActive(boolean activeStatus){
        isPlayerActive = activeStatus;
    }

    public int getHandValue() {
        return this.hand.getHandValue();
    }

    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

}
