package com.oocl.poker.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerTest {
    @Test
    public void should_return_6C_when_compare_6C_and_TH() {
        String a = "6C";
        String b = "TH";

        String winner = new Poker().compare(a,b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 3D QS";
        String b = "KH 7H 6S 9D 3S";

        String winner = new Poker().compare(a,b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_pair_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 2D QS";
        String b = "KH 7H 6S 9D 3S";

        String winner = new Poker().compare(a,b);

        assertEquals(winner, a);
    }

}
