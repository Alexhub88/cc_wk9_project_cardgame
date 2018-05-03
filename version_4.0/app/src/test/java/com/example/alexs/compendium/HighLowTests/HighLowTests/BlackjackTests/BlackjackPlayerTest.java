package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

import com.example.alexs.compendium.Blackjack.BlackjackCard;
import com.example.alexs.compendium.Blackjack.BlackjackHand;
import com.example.alexs.compendium.Blackjack.BlackjackPlayer;
import com.example.alexs.compendium.Blackjack.BlackjackRank;
import com.example.alexs.compendium.Blackjack.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackjackPlayerTest {

    private BlackjackPlayer blackjackPlayer;
    private BlackjackHand blackjackHand;
    private BlackjackCard blackjackCard;
    private BlackjackCard blackjackCard2;

    @Before
    public void setUp() {
        blackjackCard = new BlackjackCard(Suit.CLUBS, BlackjackRank.EIGHT);
        blackjackCard2 = new BlackjackCard(Suit.SPADES, BlackjackRank.ACE);
        blackjackHand = new BlackjackHand();
        blackjackPlayer = new BlackjackPlayer("Alex", blackjackHand, true, false);
    }

    @Test
    public void hasIsPlayerActive() {
        assertEquals(true, blackjackPlayer.getIsPlayerActive());
    }

    @Test
    public void hasIsBlackjack() {
        assertEquals(false, blackjackPlayer.getHasBlackjack());
    }
}
