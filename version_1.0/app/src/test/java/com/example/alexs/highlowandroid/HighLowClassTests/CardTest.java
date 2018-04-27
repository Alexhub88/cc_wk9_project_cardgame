package com.example.alexs.highlowandroid.HighLowClassTests;

import com.example.alexs.highlowandroid.HighLow.Card;
import com.example.alexs.highlowandroid.HighLow.Rank;
import com.example.alexs.highlowandroid.HighLow.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void setUp(){
        card = new Card(Suit.CLUBS, Rank.EIGHT);
    }

    @Test
    public void cardHasSuit(){
        assertEquals(Suit.CLUBS, card.getSuit());
    }

    @Test
    public void cardHasRank(){
        assertEquals(Rank.EIGHT, card.getRank());
    }

    @Test
    public void cardHasValue(){
        assertEquals(8, card.getValue());
    }

    @Test
    public void cardHasName() {
        assertEquals("Eight of Clubs", card.prettyName());
    }
}
