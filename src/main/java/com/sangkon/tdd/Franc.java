package com.sangkon.tdd;

import java.security.PublicKey;
import java.util.Objects;

public class Franc extends Money{

    public Franc(int amount) {
        this.amount = amount;
    }

//    public Franc times(int multiplier) {
//        return new Franc(amount * multiplier);
//    }

}
