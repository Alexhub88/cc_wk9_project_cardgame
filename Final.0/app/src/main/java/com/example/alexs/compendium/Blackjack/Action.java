package com.example.alexs.compendium.Blackjack;

// An enum to hold the possible actions for the player
public enum Action {

    STAND("Stand"),
    HIT("Hit");

    private String action;

    Action(String action) {
    }

    public String getAction() {
        return action;
    }
}
