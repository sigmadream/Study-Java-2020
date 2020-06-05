package com.sangkon.tdd;

import java.util.Objects;

public class Money implements Expression {
    protected int amount;

    protected String currency;

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(String to) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
