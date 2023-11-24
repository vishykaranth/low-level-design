package com.vendingmachine;

public enum Coin {
    ONE_CENT(1),
    TWO_CENTS(2),
    FIVE_CENTS(5),
    TEN_CENTS(10);

    private final int cents;

    Coin(int cents) {
        this.cents = cents;
    }

    public int cents() {
        return cents;
    }
}
