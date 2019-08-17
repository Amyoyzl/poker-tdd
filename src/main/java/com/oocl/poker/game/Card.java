package com.oocl.poker.game;

public class Card {
    private char rank;
    private char suit;

    public Card(char rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "" + rank + suit;
    }
}
