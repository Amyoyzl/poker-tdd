package com.oocl.poker.game;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    private List<Card> cards;
    private int wight;
    private Map<Card, Integer> cardsMap = new TreeMap<>();

    public Poker(String s) {
        setCards(s);
        setWight();
    }

    public void setWight() {
        calcWightBySameCards();
        if (isStraight()) { wight = 4; }
        if (isFlush()) { wight = 5; }
    }

    public Map<Card, Integer> getCardsMap() {
        return cardsMap;
    }

    public void calcWightBySameCards () {
        for (Card card : cards) {
            Integer count = cardsMap.get(card);
            if(count != null){
                cardsMap.put(card, ++count);
            }else{
                cardsMap.put(card, 1);
            }
        }
        int pairNumber = cardsMap.keySet().stream().filter(item -> cardsMap.get(item)==2).collect(Collectors.toList()).size();
        if (pairNumber == 1) { wight = 1; }
        if (pairNumber == 2) { wight = 2; }
        int threeNumber = cardsMap.keySet().stream().filter(item -> cardsMap.get(item)==3).collect(Collectors.toList()).size();
        if (threeNumber == 1) { wight = 3; }
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
            if(Card.orders.indexOf(preCardRank) + 1 != Card.orders.indexOf(nextCardRank)) {
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
