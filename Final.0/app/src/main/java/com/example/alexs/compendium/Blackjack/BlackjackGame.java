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

// Deal cards at the beginning  of the hand

    public void deal() {
        for (BlackjackPlayer player : players) {
            for (int i = 0; i < 2; i++) {
                player.addCardToHand(deck.getCard());
            }
        }
    }

// Returns a random Action for the Dealer to play

    public Action getDealerAction() {
        Action[] options = Action.values();
        Random rand = new Random();
        int index = rand.nextInt(options.length);
        return options[index];
    }

// Function checks for Blackjack, otherwise compares scores as for High Low Game

    public BlackjackPlayer checkWinner() {
        BlackjackPlayer player = players.get(0);
        BlackjackPlayer dealer = players.get(1);

        if (player.getHandValue() > 21) return dealer;
        if (player.getHasBlackjack() == true && dealer.getHasBlackjack() == true) return null;
        if (player.getHasBlackjack() == true && dealer.getHasBlackjack() == false) return player;
        if (player.getHandValue() <= 21 && dealer.getHandValue() > 21) return player;

        if (player.getHandValue() == dealer.getHandValue()) {
            return null;
        } else {
            return player.getHandValue() > dealer.getHandValue() ? player : dealer;
        }
    }

// Method to deal a card to a player at a specific position in the array of players

    public void dealCardToPlayer(int position) {

        BlackjackPlayer player = players.get(position);
        player.addCardToHand(deck.getCard());
        players.set(position, player);   //Deal card to Player

    }

    public BlackjackPlayer getPlayerAtPosition(int position) {
        return players.get(position);
    }

    public void setPlayerAtPosition(int position, BlackjackPlayer player) {
        players.set(position, player);
    }

// Check winner and display output result

    public String displayResult() {
        String resultString;

        if (checkWinner() == null) {
            resultString = "PUSH (DRAW)!";
        } else {
            if (checkWinner() == getPlayerAtPosition(0)) {
                resultString = "PLAYER 1 WINS!!";
            } else {
                resultString = "DEALER WINS!!";
            }
        }
        return resultString;
    }

// Method to implement a player's action and update the player's current state variables

    public void play(int position, Action playerAction) {

        if(getPlayerAtPosition(position).getHandValue() == 21 && getCurrentHandSize(position) == 2) {
            BlackjackPlayer player = getPlayerAtPosition(position);
            player.setHasBlackjack(true);
            setPlayerAtPosition(position, player);
        } else if (playerAction == Action.HIT) {
                dealCardToPlayer(position);
                if (getPlayerAtPosition(position).getHandValue() > 21) {
                    getPlayerAtPosition(position).setIsPlayerActive(false);    //Player Busts
                }
        } else {
            getPlayerAtPosition(position).setIsPlayerActive(false);        //Player Stands
        }
    }

// Method to update the player's score or indicate Blackjack or Bust status

    public String playerCurrentScore(int position) {
        if (position == 0) {
            if (getPlayerAtPosition(0).getHasBlackjack() == true) return "PLAYER 1 BLACKJACK!";
            if (getPlayerAtPosition(0).getHandValue() > 21) {
                return "PLAYER 1 BUSTS!";
            } else {
            return "PLAYER 1 SCORE: " + getPlayerAtPosition(0).getHandValue(); }
        } else {
            if (getPlayerAtPosition(1).getHasBlackjack() == true) return "DEALER BLACKJACK!";
            if (getPlayerAtPosition(1).getHandValue() > 21) {
                return "DEALER BUSTS!";
            } else {
                return "DEALER SCORE: " + getPlayerAtPosition(1).getHandValue();
            }
        }
    }

// Method to return the file name of the current card of the player at a given position, as a string

    public String getCardFileName (int position, int cardNumber)
    {
        return getPlayerAtPosition(position).getHand().getCards().get(cardNumber).getImageFileName();
    }
// Method to return the current number of cards in the hand of the player at a given position

    public int getCurrentHandSize(int position){
        return getPlayerAtPosition(position).getHand().getCards().size();
    }

// Method to return the string file names of the cards held by a player at a given position

    public ArrayList<String> getPlayerCardNames (int position){

        ArrayList<String> cardNameArray = new ArrayList<>();
        ArrayList<BlackjackCard> cardObjectArray= getPlayerAtPosition(position).getHand().getCards();

        for (BlackjackCard card: cardObjectArray){
            cardNameArray.add(card.getImageFileName());
        }
        return cardNameArray;
    }
}
