package com.example.alexs.compendium.HighLowTests.HighLowTests.BlackjackTests;

import com.example.alexs.compendium.Blackjack.BlackjackCard;
import com.example.alexs.compendium.Blackjack.BlackjackHand;
import com.example.alexs.compendium.Blackjack.BlackjackRank;
import com.example.alexs.compendium.Blackjack.Suit;


import org.junit.Before;
import org.junit.Test;

import static com.example.alexs.compendium.Blackjack.Suit.CLUBS;
import static org.junit.Assert.assertEquals;

public class BlackjackHandTest {

    private BlackjackHand blackjackHand;
    private BlackjackCard blackjackCard;

    @Before
    public void setUp() {
        blackjackHand = new BlackjackHand();
        blackjackCard = new BlackjackCard(Suit.CLUBS, BlackjackRank.EIGHT);
    }

    @Test
    public void valueIsZeroInitially() {

        assertEquals(0, blackjackHand.getHandValue());
    }

    @Test
    public void cardIsAdded(){
        blackjackHand.addCard(blackjackCard);
        assertEquals(1, blackjackHand.getCards().size());
    }

    @Test
    public void handHasValue(){
        blackjackHand.addCard(blackjackCard);
        assertEquals(8, blackjackHand.getHandValue());
    }

    @Test
    public void handHasSuit(){
        blackjackHand.addCard(blackjackCard);
        assertEquals(Suit.CLUBS, blackjackHand.getCards().get(0).getSuit());
    }

}
