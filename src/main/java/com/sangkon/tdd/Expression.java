package com.sangkon.tdd;

public interface Expression {
    Money reduce(Bank bank, String to);
}
