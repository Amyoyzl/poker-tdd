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
    public void should_return_draw_pokers_given_two_poker_list() {
        String a = "2C 6S 5H 3D QS";
        String b = "2C 6D 5H 3D QD";

        String winner = new Game().compare(a, b);

        assertEquals(winner, Game.DRAW);
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
    public void should_return_bigger_all_have_two_pairs_pokers() {
        String a = "2C 3S 5H 3D 5S";
        String b = "KH 6H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_treeSameCards_pair_pokers() {
        String a = "2C 6S 5H 2D QS";
        String b = "KH 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_treeSameCards_pair_pokers() {
        String a = "2C 6S 6H 6D QS";
        String b = "KH 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_straight_pair_pokers() {
        String a = "2C 6S 5H 3D 4S";
        String b = "KH 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_bigger_straight_pair_pokers() {
        String a = "2C 6S 5H 3D 4S";
        String b = "7H 8H 9S TD JS";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_have_flush_pair_pokers() {
        String a = "2C 6S 5H 3D 4S";
        String b = "9H 2H 6H 5H 3H";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_flush_pair_pokers() {
        String a = "5H 3H 9H TH QH";
        String b = "9H 2H 6H 5H 3H";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_have_full_house_pair_pokers() {
        String a = "5H 3H 9H TH QH";
        String b = "6H 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_full_house_pair_pokers() {
        String a = "5H 5S 9H 9D 9S";
        String b = "6H 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_pair_bigger_full_house_pair_pokers() {
        String a = "5H 5S 3H 3D 3S";
        String b = "6H 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_four_of_kind_pair_pokers() {
        String a = "5H 9C 9H 9D 9S";
        String b = "6H 3H 6S 3D 3S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_bigger_four_of_kind_pair_pokers() {
        String a = "5H 9C 9H 9D 9S";
        String b = "3H QC QH QD QS";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_one_four_of_kind_pair_pokers() {
        String a = "5H 9C 9H 9D 9S";
        String b = "3D 9C 9H 9D 9S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_straight_flush_compare_four_of_kind_pair_pokers() {
        String a = "5H 9C 9H 9D 9S";
        String b = "3S 4S 5S 6S 7S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, b);
    }

    @Test
    public void should_return_bigger_straight_flush_compare_pair_pokers() {
        String a = "6D 7D 8D 9D TD";
        String b = "3S 4S 5S 6S 7S";

        String winner = new Game().compare(a, b);

        assertEquals(winner, a);
    }

    @Test
    public void should_return_draw_compare_straight_flush_pair_pokers() {
        String a = "6D 7D 8D 9D TD";
        String b = "6S 7S 8S 9S TS";

        String winner = new Game().compare(a, b);

        assertEquals(winner, Game.DRAW);
    }

    @Test
    public void should_return_error_given_error_pokers() {
        String a = "6D 7D 8D 9D";
        String b = "6S 7S 8S 9S TS";

        String winner = new Game().compare(a, b);

        assertEquals(winner, Game.ERROR_POKER);
    }

}
