package com.example.alexs.compendium.Blackjack;

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
