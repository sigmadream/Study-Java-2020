package com.sangkon.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(multiplier * amount);
    }

    @Override
    String currency() {
        return "USD";
    }

}
