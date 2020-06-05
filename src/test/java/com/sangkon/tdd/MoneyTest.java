package com.sangkon.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(new Dollar(10)).isEqualTo(five.times(2));
        assertThat(new Dollar(15)).isEqualTo(five.times(3));

    }
    @Test
    public void testEquality() {
        Money five = Money.franc(5);
        assertThat(new Dollar(10)).isNotEqualTo(five.times(2));
        assertThat(new Dollar(15)).isNotEqualTo(five.times(5));
    }
}
