package com.oocl.poker.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void should_return_6C_when_compare_6C_and_TH() {
        String a = "6C";
        String b = "TH";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 3D QS";
        String b = "KH 7H 6S 9D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_pair_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 2D QS";
        String b = "KH 7H 6S 9D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_bigger_pair_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 6D QS";
        String b = "KH 7H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_bigger_one_pair_pokers_given_two_pokers_all_have_same_pair() {
        String a = "2C 3S 5H 3D QS";
        String b = "KH 7H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_two_pairs_pokers() {
        String a = "2C 3S 5H 3D 5S";
        String b = "KH 5H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_treeSameCards_pair_pokers() {
        String a = "2C 6S 5H 2D QS";
        String b = "KH 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_straight_pair_pokers() {
        String a = "2C 6S 5H 3D 4S";
        String b = "KH 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_flush_pair_pokers() {
        String a = "2C 6S 5H 3D 4S";
        String b = "9H 2H 6H 5H 3H";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

}
