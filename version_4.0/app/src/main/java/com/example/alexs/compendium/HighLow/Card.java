package com.example.alexs.compendium.HighLow;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue(){
        return this.rank.getValue();
    }

    public String prettyName(){
        return (rank.getName() + " of " + suit.getSuit());
    }

//A function to show the card file name of a given Card object and output the result as a String
    public String getImageFileName(){

        String fileName;

        switch (rank.getValue()) {
            case 10:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "ten";
                break;
            case 11:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "j";
                break;
            case 12:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "q";
                break;
            case 13:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "k";
                break;
            case 14:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + "a";
                break;
            default:
                fileName =  suit.getSuit().substring(0, 1).toLowerCase() + rank.getValue();
                break;
        }

        return fileName;
    }
}
