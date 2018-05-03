package com.example.alexs.compendium.HighLowTests.HighLowTests;


import com.example.alexs.compendium.HighLow.Card;
import com.example.alexs.compendium.HighLow.Hand;
import com.example.alexs.compendium.HighLow.Rank;
import com.example.alexs.compendium.HighLow.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {

    Hand hand;
    Card card;
    Card card2;

    @Before
    public void setUp(){
        hand = new Hand();
        card = new Card(Suit.CLUBS, Rank.JACK);
    }

    @Test
    public void valueIs0Initially(){
        assertEquals(0, hand.getHandValue());
    }

    @Test
    public void cardIsAdded(){
        hand.addCard(card);
        assertEquals(1, hand.getCards().size());
    }

    @Test
    public void handHasValue(){
        hand.addCard(card);
        assertEquals(11, hand.getHandValue());
    }

    @Test
    public void handHasSuit(){
        hand.addCard(card);
        assertEquals(Suit.CLUBS, hand.getCards().get(0).getSuit());
    }

    @Test
    public void testResetHand(){
        hand.addCard(card);
        assertEquals(Suit.CLUBS, hand.getCards().get(0).getSuit());
        hand.resetHand();
        assertEquals(0, hand.getHandValue());
    }
}
