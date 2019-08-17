package com.oocl.poker.game;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable {
    private char rank;
    private char suit;

    public final static List<Character> orders = Arrays.asList(new Character[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'});

    public Card(char rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "" + rank + suit;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        return orders.indexOf(this.getRank()) - orders.indexOf(card.getRank());
    }

    @Override
    public int hashCode() {
        return this.getRank();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getRank() == ((Card) obj).getRank();
    }
}
