package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

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
        blackjackPlayer1 = new BlackjackPlayer("Alice", new BlackjackHand(), true, false);
        blackjackPlayer2 = new BlackjackPlayer("Bob", new BlackjackHand(), true, false);
        players.add(blackjackPlayer1);
        players.add(blackjackPlayer2);
        blackjackGame = new BlackjackGame(blackjackDeck, players);
    }

    @Test
    public void testCheckWinner() {
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.FIVE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.NINE));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.QUEEN));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.JACK));

        BlackjackPlayer winner = blackjackGame.checkWinner();
        assertEquals("Bob", winner.getName());
    }


    @Test
    public void canDisplayResult() {
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.DIAMONDS, BlackjackRank.ACE));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.HEARTS, BlackjackRank.TEN));
        blackjackPlayer2.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.SPADES, BlackjackRank.FOUR));
        blackjackPlayer1.addCardToHand(new BlackjackCard(com.example.alexs.compendium.Blackjack.Suit.CLUBS, BlackjackRank.THREE));

        assertEquals("DEALER WINS!!", blackjackGame.displayResult());
    }

}
