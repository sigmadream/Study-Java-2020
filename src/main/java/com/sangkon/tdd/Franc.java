package com.sangkon.tdd;

import java.util.Objects;

public class Franc extends Money {
    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(multiplier * amount);
    }

}
