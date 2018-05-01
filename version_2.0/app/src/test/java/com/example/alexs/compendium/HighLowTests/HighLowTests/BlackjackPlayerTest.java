package com.example.alexs.compendium.HighLowTests.HighLowTests;


import com.example.alexs.compendium.HighLow.Card;
import com.example.alexs.compendium.HighLow.Hand;
import com.example.alexs.compendium.HighLow.Player;
import com.example.alexs.compendium.HighLow.Rank;
import com.example.alexs.compendium.HighLow.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackjackPlayerTest {

    Player player;
    Hand hand;
    Card card;
    Card card2;

    @Before
    public void setup(){
        hand = new Hand();
        player = new Player("Ally", hand);
        card = new Card(Suit.DIAMONDS, Rank.ACE);
        card2 = new Card(Suit.SPADES, Rank.FOUR);
    }

    @Test
    public void playerHasName(){
        assertEquals("Ally", player.getName());
    }

    @Test
    public void playerCanTakeCard(){
        player.addCardToHand(card);
        assertEquals(1, player.getHand().getNumberOfCards());
    }

    @Test
    public void playerHandValueIs17(){
        player.addCardToHand(card);
        player.addCardToHand(card2);
        assertEquals(18, player.getHandValue());
    }
}
