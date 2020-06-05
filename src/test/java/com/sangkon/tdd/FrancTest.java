package com.sangkon.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {
    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5, "CHF");
        assertThat(new Franc(10, "CHF")).isEqualTo(five.times(2));
        assertThat(new Franc(15, "CHF")).isEqualTo(five.times(3));
    }

    @Test
    public void testFrancEquality() {
        assertThat(new Franc(5, "CHF")).isEqualTo(new Franc(5, "CHF"));
        assertThat(new Franc(5, "CHF")).isNotEqualTo(new Franc(6, "CHF"));
    }
}