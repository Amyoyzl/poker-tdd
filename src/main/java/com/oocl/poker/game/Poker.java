package com.oocl.poker.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poker {
    private final static List<Character> orders = Arrays.asList(new Character[]{'2','3','4','5','6','7','8','9','T','J','Q','K','A'});
    public String compare(String a, String b) {
        List<Card> cardsA = changeToCard(a);
        List<Card> cardsB = changeToCard(b);
        if (1 == cardsA.size() && 1 == cardsB.size()) {
            return compareOne(cardsA.get(0), cardsB.get(0));
        }
        return "";
    }

    private String compareOne(Card cardA, Card cardB) {
        if (orders.indexOf(cardA.getRank()) > orders.indexOf(cardB.getRank())) {
            return cardA.toString();
        }
        if (orders.indexOf(cardA.getRank()) == orders.indexOf(cardB.getRank())) {
            return "Draw";
        }
        return cardB.toString();
    }

    private List<Card> changeToCard(String cardsStr) {
        String[] strCards = cardsStr.trim().split(" ");
        List<Card> cards = new ArrayList<>();
        for (String strCard : strCards) {
            strCard = strCard.trim();
            if (strCard.toCharArray().length < 2) {
                System.out.println("牌型输入有误！");
                return null;
            } else {
                cards.add(new Card(strCard.charAt(0), strCard.charAt(1)));
            }
        }
        return cards;
    }
}
