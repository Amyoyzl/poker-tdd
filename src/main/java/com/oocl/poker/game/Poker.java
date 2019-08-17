package com.oocl.poker.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poker {
    private List<Card> cards;
    private int wight;
    private int max;

    public Poker(String s) {
        setCards(s);
        setMax();
        setWight();
    }

    public void setWight() {
        int count = 1;
        Card maxCard = null;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).equals(cards.get(i + 1))) {
                count++;
                maxCard = cards.get(i);
            }
        }
        wight = count > 2 ? 2 : ((count > 1) ? 1 : 0);
        if (maxCard != null) {
            max = Card.orders.indexOf(maxCard.getRank());
        }
    }

    public void setMax() {
        max = Card.orders.indexOf(cards.get(cards.size() - 1).getRank());
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

    public int getMax() {
        return max;
    }

    public int getWight() {
        return wight;
    }
}
