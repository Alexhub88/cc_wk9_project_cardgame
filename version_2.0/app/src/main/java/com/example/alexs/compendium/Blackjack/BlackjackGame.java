package com.example.alexs.compendium.Blackjack;

import java.util.ArrayList;
import java.util.Random;

public class BlackjackGame {

    private BlackjackDeck deck;
    private ArrayList<BlackjackPlayer> players;

    public BlackjackGame(BlackjackDeck deck, ArrayList<BlackjackPlayer> players) {
        this.deck = deck;
        this.players = players;
    }

    public void deal(){
        for (BlackjackPlayer player : players){
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

    public BlackjackPlayer checkWinner(){
        BlackjackPlayer player = players.get(0);
        BlackjackPlayer dealer = players.get(1);

        if (player.getHandValue() > 21 || dealer.getHasBlackjack() ==true) return dealer;
        if (player.getHasBlackjack() == true && dealer.getHasBlackjack() ==false) return player;
        if (player.getHandValue() <= 21 && dealer.getHandValue() > 21) return player;

        if (player.getHandValue() == dealer.getHandValue()){
            return null;
        } else {
            return player.getHandValue() > dealer.getHandValue() ? player :  dealer;
        }
    }

    public void dealCardToPlayer (int position){

        BlackjackPlayer player = players.get(position);
        player.addCardToHand(deck.getCard());
        players.set(position, player);

    }

    public BlackjackPlayer getPlayerAtPosition(int position){
        return players.get(position);
    }

    public void setPlayerAtPosition(int position, BlackjackPlayer player){
        players.set(position, player);
    }

    public String displayResult(){
        String resultString;

        if (checkWinner() == null){
            resultString = "RESULT: " +"\n\n" +"PUSH (DRAW)!";
        } else {
            if (checkWinner() == getPlayerAtPosition(0)) {
            resultString = "RESULT: " +"\n\n" +"PLAYER 1 WINS!!";
            } else {
                resultString = "RESULT:" +"\n\n" + " DEALER WINS!!";
            }
        }
        return resultString;
    }


}
