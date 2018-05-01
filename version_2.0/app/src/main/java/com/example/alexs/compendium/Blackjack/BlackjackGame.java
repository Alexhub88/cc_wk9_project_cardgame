package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackGame {

    private BlackjackDeck deck;
    private ArrayList<BlackjackPlayer> blackjackPlayers;

    public BlackjackGame(BlackjackDeck deck, ArrayList<BlackjackPlayer> blackjackPlayers) {
        this.deck = deck;
        this.blackjackPlayers = blackjackPlayers;
    }

    public void deal(){
        for (BlackjackPlayer blackjackPlayer : blackjackPlayers){
            for(int i = 0; i<2; i++) {
                blackjackPlayer.addCardToHand(deck.getCard());
            }
        }
    }

    public Action getDealerAction() {
        Action[] options = Action.values();
        Random rand = new Random();
        int index = rand.nextInt(options.length);
        return options[index];
    }

    public BlackjackPlayer checkWinner(){
        BlackjackPlayer blackjackPlayer = blackjackPlayers.get(0);
        BlackjackPlayer dealer = blackjackPlayers.get(1);

        if (blackjackPlayer.getHandValue() > 21) return dealer;

        if (blackjackPlayer.getHandValue() <= 21 && dealer.getHandValue() > 21) return blackjackPlayer;

        if (blackjackPlayer.getHandValue() == dealer.getHandValue()){
            return null;
        } else {
            return blackjackPlayer.getHandValue() > dealer.getHandValue() ? blackjackPlayer :  dealer;
        }
    }

    public void dealCardToPlayer (int position){

        BlackjackPlayer blackjackPlayer = blackjackPlayers.get(position);
        blackjackPlayer.addCardToHand(deck.getCard());
        blackjackPlayers.set(position, blackjackPlayer);

    }

    public BlackjackPlayer getPlayerAtPosition(int position){
        return blackjackPlayers.get(position);
    }

    public void setPlayerAtPosition(int position, BlackjackPlayer blackjackPlayer){
        blackjackPlayers.set(position, blackjackPlayer);
    }


}
