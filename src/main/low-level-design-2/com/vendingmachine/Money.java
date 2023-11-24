package com.vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Money {
    private final Map<Coin, Integer> coinAmounts;

    private Money() {
        this.coinAmounts = new HashMap<>();
    }

    private Money(Map<Coin, Integer> coinAmounts) {
        this.coinAmounts = new HashMap<>(coinAmounts);
    }

    public static Money from(Coin... coins) {
        Money m = new Money();
        for (Coin coin : coins) {
            m.add(coin);
        }

        return m;
    }

    public static Money from(Money money) {
        return new Money(money.coinAmounts);
    }

    public static Money empty() {
        return new Money();
    }

    public Money add(Coin coin) {
        add(coin, 1);

        return this;
    }

    public Money add(Money money) {
        money.coinAmounts.forEach(this::add);

        return this;
    }

    public Money add(Coin c, int amount) {
        coinAmounts.put(c, coinAmounts.getOrDefault(c, 0) + amount);

        return this;
    }

    public int amount() {
        return coinAmounts.entrySet().stream()
                .map(e -> e.getKey().cents() * e.getValue())
                .reduce(0, Integer::sum);
    }

    private void remove(Coin coin) {
        int amount = coinAmounts.getOrDefault(coin, 0);

        if (amount == 0) {
            throw new RuntimeException("Cannot remove non existing coin");
        }

        coinAmounts.put(coin, amount - 1);
    }

    private List<Coin> availableSortedCoins() {
        return coinAmounts.keySet().stream()
                .sorted((c1, c2) -> Integer.compare(c2.cents(), c1.cents()))
                .collect(Collectors.toList());
    }

    private boolean hasCoin(Coin c) {
        return coinAmounts.containsKey(c);
    }

    public Money changeFor(int amount) {
        int changeAmount = amount;
        Money changeMoney = Money.empty();

        for (Coin coin : availableSortedCoins()) {
            while (coin.cents() <= changeAmount && hasCoin(coin)) {
                changeAmount -= coin.cents();
                changeMoney.add(coin);
                remove(coin);
            }
        }

        return changeMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(coinAmounts, money.coinAmounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coinAmounts);
    }

    @Override
    public String toString() {
        return coinAmounts.entrySet().stream()
                .map(e -> e.getValue() + "x" + e.getKey().toString())
                .collect(Collectors.joining(","));
    }
}
