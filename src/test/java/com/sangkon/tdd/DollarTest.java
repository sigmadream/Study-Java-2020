package com.sangkon.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {
    @Test
    public void testDollarMultiplication() {
        Dollar five = new Dollar(5, "USD");
        assertThat(new Dollar(10, "USD")).isEqualTo(five.times(2));
        assertThat(new Dollar(15, "USD")).isEqualTo(five.times(3));
    }

    @Test
    public void testDollarEquality() {
        assertThat(new Dollar(5, "USD")).isEqualTo(new Dollar(5, "USD"));
        assertThat(new Dollar(5, "USD")).isNotEqualTo(new Dollar(6, "USD"));
    }
}
