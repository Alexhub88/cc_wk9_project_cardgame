package com.example.alexs.compendium.Blackjack;

import com.example.alexs.compendium.HighLow.Deck;
import com.example.alexs.compendium.Blackjack.Player;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void deal(){
        for (Player player : players){
            for(int i = 0; i<2; i++) {
                player.addCardToHand(deck.getCard());
            }
        }
    }

    public Action getDealerAction() {
        Action[] options = Action.values();
        Random rand = new Random();
        int index = rand.nextInt(options.length);
        return options[index];
    }

    public Player checkWinner(){
        Player player = players.get(0);
        Player dealer = players.get(1);

        if (player.getHandValue() > 21) return dealer;

        if (player.getHandValue() <= 21 && dealer.getHandValue() > 21) return player;

        if (player.getHandValue() == dealer.getHandValue()){
            return null;
        } else {
            return player.getHandValue() > dealer.getHandValue() ?  player :  dealer;
        }
    }

    public void dealCardToPlayer (int position){

        Player player = players.get(position);
        player.addCardToHand(deck.getCard());
        players.set(position, player);

    }

    public Player getPlayerAtPosition(int position){
        return players.get(position);
    }

    public void setPlayerAtPosition(int position, Player player){
        players.set(position, player);
    }


}
