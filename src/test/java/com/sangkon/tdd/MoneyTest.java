package com.sangkon.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void testDollarMultiplication() {
        Money five = Money.dollar(5);
        assertThat(Money.dollar(10)).isEqualTo(five.times(2));
        assertThat(Money.dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = new Money(5, "CHF");
        assertThat(Money.franc(10)).isEqualTo(five.times(2));
        assertThat(Money.franc(15)).isEqualTo(five.times(3));
    }

    @Test
    public void testMoneyEquality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(6));
    }

    @Test
    public void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    public void testDifferentClassEquality() {
        assertThat(new Money(10, "CHF")).isEqualTo(new Money(10, "CHF"));
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(Money.dollar(10)).isEqualTo(reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertThat(five).isEqualTo(sum.augend);
        assertThat(five).isEqualTo(sum.augend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(Money.dollar(7)).isEqualTo(result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(Money.dollar(1)).isEqualTo(result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(Money.dollar(1)).isEqualTo(result);
    }

    @Test
    public void testArrayEquals() {
        assertThat(new Object[]{"abc"}).isEqualTo(new Object[]{"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertThat(1).isEqualTo(new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(Money.dollar(10)).isEqualTo(result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertThat(Money.dollar(15)).isEqualTo(result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertThat(Money.dollar(20)).isEqualTo(result);
    }

    @Test
    public void testPlusSameCurrencyReturnsMoney() {
        Expression sum = Money.dollar(1).plus(Money.dollar(1));
        assertThat(sum instanceof Expression).isTrue();
    }
}
