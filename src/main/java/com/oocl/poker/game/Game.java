package com.oocl.poker.game;

public class Game {

    public final static String DRAW = "Draw";

    public String compare(String a, String b) {
        Poker pokerA = new Poker(a);
        Poker pokerB = new Poker(b);
        if (pokerA.getCards().size() != pokerB.getCards().size()) {
            return "双方牌数量不一致！";
        }
        if (pokerA.getWight() > pokerB.getWight()) { return a; }
        if (pokerA.getWight() < pokerB.getWight()) { return b; }
        if (pokerA.getMax() == pokerB.getMax()) {
            return DRAW;
        }
        return pokerA.getMax() > pokerB.getMax() ? a : b;
    }

}
