package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

import com.example.alexs.compendium.Blackjack.Action;
import com.example.alexs.compendium.Blackjack.BlackjackCard;
import com.example.alexs.compendium.Blackjack.BlackjackDeck;
import com.example.alexs.compendium.Blackjack.BlackjackGame;
import com.example.alexs.compendium.Blackjack.BlackjackHand;
import com.example.alexs.compendium.Blackjack.BlackjackPlayer;
import com.example.alexs.compendium.Blackjack.BlackjackRank;
import com.example.alexs.compendium.HighLow.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BlackjackGameTest {
    BlackjackDeck blackjackDeck;
    BlackjackPlayer blackjackPlayer1;
    BlackjackPlayer blackjackPlayer2;
    ArrayList<BlackjackPlayer> players;
    private BlackjackGame blackjackGame;

    @Before
    public void setUp() {

        blackjackDeck = new BlackjackDeck();
        players = new ArrayList<>();
        blackjackPlayer1 = new BlackjackPlayer("Player 1", new BlackjackHand(), true, false);
        blackjackPlayer2 = new BlackjackPlayer("Dealer", new BlackjackHand(), true, false);
        players.add(blackjackPlayer1);
        players.add(blackjackPlayer2);
        blackjackGame = new BlackjackGame(blackjackDeck, players);
    }

// Check that the game can deal cards correctly

    @Test
    public void checkDeal(){
        blackjackGame.deal();
        assertEquals(2, blackjackPlayer1.getHand().getNumberOfCards());
        assertEquals(2, blackjackPlayer2.getHand().getNumberOfCards());
    }

// Test that Player wins when dealt a higher hand

    @Test
    public void player1WinsWithHigherHand(){
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.ACE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.SIX));
        BlackjackPlayer winner = blackjackGame.checkWinner();
        assertEquals("Player 1", winner.getName());
    }

// Test that the Player wins when they have Blackjack

    @Test
    public void player1WinsWithBlackjack(){
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.ACE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.TEN));
        blackjackPlayer1.setHasBlackjack(true);
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.SIX));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.SIX));
        BlackjackPlayer winner = blackjackGame.checkWinner();
        assertEquals("Player 1", winner.getName());
    }

    // Test that the Dealer wins when both players bust

    @Test
    public void dealerWinsWhenBothBust(){
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.ACE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.ACE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.ACE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.ACE));
        BlackjackPlayer winner = blackjackGame.checkWinner();
        assertEquals("Dealer", winner.getName());
    }

// Test that the play function deals a card when the Player Hits

    @Test
    public void testPlayFunctionHit(){
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.FOUR));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.SIX));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.THREE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.FOUR));
        assertEquals(2, blackjackPlayer1.getHand().getNumberOfCards());
        blackjackGame.play(0, Action.HIT);
        assertEquals(3, blackjackPlayer1.getHand().getNumberOfCards());
    }

// Test that the play function changes a player's Active status to false when the Player Stands

    @Test
    public void testPlayFunctionStand(){
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.FOUR));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.SIX));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.THREE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.FOUR));
        assertEquals(true, blackjackPlayer1.getIsPlayerActive());
        blackjackGame.play(0, Action.STAND);
        assertEquals(false, blackjackPlayer1.getIsPlayerActive());
    }

// Check that the checkWinner function assigns the winner correctly

    @Test
    public void testCheckWinner() {
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.FIVE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.NINE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.QUEEN));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.JACK));

        BlackjackPlayer winner = blackjackGame.checkWinner();
        assertEquals("Dealer", winner.getName());
    }


// Check that the code to display the game result is working correctly

    @Test
    public void canDisplayResult() {
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.ACE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.TEN));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.FOUR));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.THREE));

        assertEquals("DEALER WINS!!", blackjackGame.displayResult());
    }

}
