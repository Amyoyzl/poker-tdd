package com.oocl.poker.game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {

    public final static String DRAW = "Draw";

    public String compare(String a, String b) {
        Poker pokerA = new Poker(a);
        Poker pokerB = new Poker(b);
        if (pokerA.getCards().size() != pokerB.getCards().size()) {
            return "双方牌数量不一致！";
        }
        if (pokerA.getWight() > pokerB.getWight()) {
            return a;
        }
        if (pokerA.getWight() < pokerB.getWight()) {
            return b;
        }
        int compareOneResult = 0;
        int count = 1;
        if (pokerA.getWight() == 1 || pokerA.getWight() == 2) { count = 2; }
        if (pokerA.getWight() == 3 || pokerA.getWight() == 6) { count = 3; }
        if (pokerA.getWight() == 7) { count = 4; }
        compareOneResult = compareOne(getGroupCards(pokerA.getCardsMap(), count),
                getGroupCards(pokerB.getCardsMap(), count));
        if (compareOneResult == 0) {
            count = pokerA.getWight() == 6 ? 2 : 1;
            int compareCardsResult = compareOne(getGroupCards(pokerA.getCardsMap(), count),
                    getGroupCards(pokerB.getCardsMap(), count));
            if (compareCardsResult == 0) { return DRAW; }
            return compareCardsResult > 0 ? a : b;
        }
        return compareOneResult > 0 ? a : b;
    }

    public List getGroupCards(Map<Card, Integer> cardsMap, int count) {
        return cardsMap.keySet().stream().filter(item -> cardsMap.get(item) == count).collect(Collectors.toList());
    }

    public int compareOne(List<Card> pokerA, List<Card> pokerB) {
        for (int i = pokerA.size() - 1; i >= 0; i--) {
            if (pokerA.get(i).compareTo(pokerB.get(i)) > 0) { return 1; }
            if (pokerA.get(i).compareTo(pokerB.get(i)) < 0) { return -1; }
        }
        return 0;
    }

}
