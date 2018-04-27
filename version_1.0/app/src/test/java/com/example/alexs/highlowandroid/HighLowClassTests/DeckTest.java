package com.example.alexs.highlowandroid.HighLowClassTests;

import com.example.alexs.highlowandroid.HighLow.Card;
import com.example.alexs.highlowandroid.HighLow.Deck;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp(){
            deck = new Deck();
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void canGetCard() {
        Card card = deck.getCard();
        assertNotNull(card);
    }
}
