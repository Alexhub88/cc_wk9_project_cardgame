package com.example.alexs.compendium.Blackjack;
//BlackjackCard getImageFileName different from Card getImageFileName as Ranks differ
public class BlackjackCard {

    private Suit suit;
    private BlackjackRank rank;

    public BlackjackCard(Suit suit, BlackjackRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {                               // Standard getter method for suit
        return suit;
    }

    public BlackjackRank getRank() {
        return rank;
    }       // Standard getter method for rank

    public int getValue(){
        return this.rank.getValue();
    }

    public String prettyName(){
        return (rank.getName() + " of " + suit.getSuit());
    }


// Method to return the file name of the BlackjackCard as a String, .e.g "Eight of Clubs" returns "c8"
    public String getImageFileName(){

        String fileName;

        switch (rank.getValue()) {
            case 10:
                if (rank.getName() == "Ten"){
                    fileName = suit.getSuit().substring(0, 1).toLowerCase()
                            + "ten";
                } else {
                    fileName = suit.getSuit().substring(0, 1).toLowerCase()
                            + rank.getName().substring(0, 1).toLowerCase();
                }
                break;
            case 11:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "a";
                break;
            default:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + rank.getValue();
                break;
        }

        return fileName;
    }
}
