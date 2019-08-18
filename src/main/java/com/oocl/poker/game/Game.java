package com.oocl.poker.game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    public final static String DRAW = "Draw";
    public final static String ERROR_POKER = "双方牌数量不一致！";

    public String compare(String a, String b) {
        Poker pokerA = new Poker(a);
        Poker pokerB = new Poker(b);
        if (isValid(pokerA, pokerB)) return ERROR_POKER;
        if (pokerA.getWight() > pokerB.getWight()) return a;
        if (pokerA.getWight() < pokerB.getWight()) return b;
        int sameCardNumber = getSameCardNumber(pokerA.getWight());
        int compareOneResult = compare(getGroupCards(pokerA, sameCardNumber),
                getGroupCards(pokerB, sameCardNumber));
        if (compareOneResult > 0) return a;
        if (compareOneResult < 0) return b;
        sameCardNumber = pokerA.getWight() == Poker.FULL_HOUSE ? 2 : 1;
        compareOneResult = compare(getGroupCards(pokerA, sameCardNumber),
                getGroupCards(pokerB, sameCardNumber));
        if (compareOneResult == 0) return DRAW;
        return compareOneResult > 0 ? a : b;
    }

    private boolean isValid(Poker pokerA, Poker pokerB) {
        if (pokerA.getCards().size() != pokerB.getCards().size()) {
            return true;
        }
        return false;
    }

    private int getSameCardNumber(int weight) {
        switch (weight) {
            case Poker.PAIR:
            case Poker.TWO_PAIRS:
                return 2;
            case Poker.THREE_OF_KIND:
            case Poker.FULL_HOUSE:
                return 3;
            case Poker.FOUR_OF_KIND:
                return 4;
            default:
                return 1;
        }
    }

    public List getGroupCards(Poker poker, int sameCardNumber) {
        Map<Card, Integer> cardsMap = poker.getCardsMap();
        return cardsMap.keySet().stream().filter(item -> cardsMap.get(item) == sameCardNumber).collect(Collectors.toList());
    }

    public int compare(List<Card> pokerA, List<Card> pokerB) {
        for (int i = pokerA.size() - 1; i >= 0; i--) {
            if (pokerA.get(i).compareTo(pokerB.get(i)) > 0) return 1;
            if (pokerA.get(i).compareTo(pokerB.get(i)) < 0) return -1;
        }
        return 0;
    }

}
