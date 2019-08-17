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
}
