package com.oocl.poker.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {

    public final static String DRAW = "Draw";

    public String compare(String a, String b) {
        List<Card> cardsA = changeToCard(a);
        List<Card> cardsB = changeToCard(b);
        if (1 == cardsA.size() && 1 == cardsB.size()) {
            if (cardsA.get(0).compareTo(cardsB.get(0)) == 0) { return DRAW; }
            return cardsA.get(0).compareTo(cardsB.get(0)) > 0 ? a : b;
        }
        if (cardsA.size() != cardsB.size()) {
            return "双方牌数量不一致！";
        }
        Collections.sort(cardsA);
        Collections.sort(cardsB);
        if (hasPair(cardsA) && !hasPair(cardsB)) {
            return a;
        }
        if (!hasPair(cardsA) && hasPair(cardsB)) {
            return b;
        }
        for (int i = cardsA.size() - 1; i >= 0; i --) {
            if (cardsA.get(i).compareTo(cardsB.get(i)) == 0) {
                continue;
            }
            return cardsA.get(i).compareTo(cardsB.get(i)) > 0 ? a : b;
        }
        return DRAW;
    }

    private boolean hasPair (List<Card> cards) {
        if(cards.stream().distinct().count() == cards.size() - 1) {
            return true;
        }
        return false;
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
