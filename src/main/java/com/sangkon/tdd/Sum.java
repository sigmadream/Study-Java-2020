package com.sangkon.tdd;

public class Sum implements Expression {
    Money augend;
    Money addend;

    public Sum(Money money, Money addend) {
        this.augend = money;
        this.addend = addend;
    }

    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }

}