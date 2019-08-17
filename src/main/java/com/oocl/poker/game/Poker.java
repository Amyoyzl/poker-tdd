package com.oocl.poker.game;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    private List<Card> cards;
    private int wight;
    private Map<Card, Integer> cardsMap = new TreeMap<>();
    public final static int PAIR = 1;
    public final static int TWO_PAIRS = 2;
    public final static int THREE_OF_KIND = 3;
    public final static int STRAIGHT = 4;
    public final static int FLUSH = 5;
    public final static int FULL_HOUSE = 6;
    public final static int FOUR_OF_KIND = 7;
    public final static int STRAIGHT_FLUSH = 8;

    public Poker(String s) {
        setCards(s);
        setCardsMap();
        setWight();
    }

    public void setWight() {
        calcWightBySameCards();
        if (isStraight()) { wight = STRAIGHT; }
        if (isFlush()) { wight = FLUSH; }
        if (isFlush() && isStraight()) { wight = STRAIGHT_FLUSH; }
    }

    public Map<Card, Integer> getCardsMap() {
        return cardsMap;
    }

    public void setCardsMap() {
        for (Card card : cards) {
            Integer count = cardsMap.get(card);
            if(count != null){
                cardsMap.put(card, ++count);
            }else{
                cardsMap.put(card, 1);
            }
        }
    }

    public void calcWightBySameCards () {
        int pairNumber = cardsMap.keySet().stream().filter(item -> cardsMap.get(item) == 2).collect(Collectors.toList()).size();
        if (pairNumber == 1) { wight = PAIR; }
        if (pairNumber == 2) { wight = TWO_PAIRS; }
        int threeNumber = cardsMap.keySet().stream().filter(item -> cardsMap.get(item) == 3).collect(Collectors.toList()).size();
        if (threeNumber == 1) { wight = THREE_OF_KIND; }
        if (threeNumber == 1 && pairNumber == 1) { wight = FULL_HOUSE; }
        int fourNumber = cardsMap.keySet().stream().filter(item -> cardsMap.get(item) == 4).collect(Collectors.toList()).size();
        if (fourNumber == 1) { wight = FOUR_OF_KIND; }
    }

    public boolean isFlush() {
        for (int i = 0; i < cards.size() - 1; i++) {
            char preCardSuit = cards.get(i).getSuit();
            char nextCardSuit = cards.get(i + 1).getSuit();
            if(preCardSuit != nextCardSuit) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
        for (int i = 0; i < cards.size() - 1; i++) {
            char preCardRank = cards.get(i).getRank();
            char nextCardRank = cards.get(i + 1).getRank();
            if(Card.ORDERS.indexOf(preCardRank) + 1 != Card.ORDERS.indexOf(nextCardRank)) {
                return false;
            }
        }
        return true;
    }

    public List<Card> getCards() {
        return cards;
    }

    private void setCards(String cardsStr) {
        String[] strCards = cardsStr.trim().split(" ");
        this.cards = new ArrayList<>();
        for (String strCard : strCards) {
            strCard = strCard.trim();
            if (strCard.toCharArray().length < 2) {
                System.out.println("牌型输入有误！");
                break;
            } else {
                cards.add(new Card(strCard.charAt(0), strCard.charAt(1)));
            }
        }
        Collections.sort(cards);
    }

    public int getWight() {
        return wight;
    }
}
