package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

import com.example.alexs.compendium.Blackjack.BlackjackCard;
import com.example.alexs.compendium.Blackjack.BlackjackDeck;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BlackjackDeckTest {
    private BlackjackDeck blackjackDeck;

    @Before
    public void setUp(){
        blackjackDeck = new BlackjackDeck();
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, blackjackDeck.getNumberOfCards());
    }

    @Test
    public void canGetCard() {
        BlackjackCard blackjackCard = blackjackDeck.getCard();
        assertNotNull(blackjackCard);
        assertEquals(51, blackjackDeck.getNumberOfCards());
    }
}

