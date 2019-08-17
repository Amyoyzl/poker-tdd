package com.oocl.poker.game;

import java.util.Arrays;
import java.util.List;

public class Poker {
    private final static List<Character> orders = Arrays.asList(new Character[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'});
    public String compare(String a, String b) {
        Card cardA = changeToCard(a);
        Card cardB = changeToCard(b);
        if (orders.indexOf(cardA.getRank()) > orders.indexOf(cardB.getRank())) {
            return cardA.toString();
        }
        if (orders.indexOf(cardA.getRank()) == orders.indexOf(cardB.getRank())) {
            return "Draw";
        }
        return cardB.toString();
    }

    private Card changeToCard(String cardStr) {
        if(cardStr.toCharArray().length < 2) {
            return null;
        }
        return new Card(cardStr.charAt(0), cardStr.charAt(1));
    }
}
