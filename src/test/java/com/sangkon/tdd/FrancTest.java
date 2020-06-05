package com.sangkon.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {
    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertThat(new Franc(10)).isEqualTo(five.times(2));
        assertThat(new Franc(15)).isEqualTo(five.times(3));
    }
}
