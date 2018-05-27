package com.example.alexs.compendium.HighLow;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
    }

// Logic to deal 2 cards to each player

    public void deal(){
        for (Player player : players){
            for(int i = 0; i<2; i++) {
                player.addCardToHand(deck.getCard());
            }
        }
    }

// Logic to get the hand values for both players, compare them and decide on the winner

    public Player checkWinner(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        if (player1.getHandValue() == player2.getHandValue()){
            return null;
        } else {
            return player1.getHandValue() > player2.getHandValue() ?  player1 :  player2;
        }
    }
}
