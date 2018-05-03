package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

import com.example.alexs.compendium.Blackjack.BlackjackCard;
import com.example.alexs.compendium.Blackjack.BlackjackRank;
import com.example.alexs.compendium.Blackjack.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackjackCardTest {

    private BlackjackCard blackjackCard;

    @Before
    public void setUp(){blackjackCard= new BlackjackCard(Suit.CLUBS, BlackjackRank.EIGHT);}

    @Test
    public void cardHasSuit(){
        assertEquals(Suit.CLUBS, blackjackCard.getSuit());
    }

    @Test
    public void cardHasRank(){
        assertEquals(BlackjackRank.EIGHT, blackjackCard.getRank());
    }

    @Test
    public void cardHasValue(){
        assertEquals(8, blackjackCard.getValue());
    }

    @Test
    public void testCardPrettyName() {

        assertEquals("Eight of Clubs", blackjackCard.prettyName());
    }

    @Test
    public void testGetImageFileName(){
        assertEquals("c8", blackjackCard.getImageFileName());
    }

}
