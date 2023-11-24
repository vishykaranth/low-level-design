package com.vendingmachine;

import java.util.*;

public class VendingMachine {
    private Money machineMoney;
    private Money insertedMoney = Money.empty();
    private final Map<Integer, Item> items;

    private VendingMachine(Money money, Map<Integer, Item> items) {
        this.machineMoney = money;
        this.items = items;
    }

    public void insert(Money m) {
        insertedMoney.add(m);
    }

    public Money buy(int itemCode) {
        return buy(itemCode, false);
    }

    public Money forceBuy(int itemCode) {
        return buy(itemCode, true);
    }

    private Money buy(int itemCode, boolean keepChange) {
        if (!items.containsKey(itemCode)) {
            throw new ItemNotFound();
        }

        int amount = items.get(itemCode).getPrice();

        int insertedAmount = insertedMoney.amount();
        if (insertedAmount - amount < 0) {
            throw new InsufficientFunds();
        }

        Money money = Money.from(machineMoney).add(insertedMoney);

        int changeAmount = insertedAmount - amount;
        Money change = money.changeFor(changeAmount);
        if (!keepChange && changeAmount > change.amount()) {
            throw new NotEnoughChange();
        }

        // if everything goes well, change the state
        machineMoney = money;
        insertedMoney = Money.empty();

        return change;
    }

    public static VendingMachineBuilder builder() {
        return new VendingMachineBuilder();
    }

    public Money cancel() {
        Money money = insertedMoney;
        insertedMoney = Money.empty();

        return money;
    }

    static class VendingMachineBuilder {
        private Money money = Money.empty();
        private final Map<Integer, Item> items = new HashMap<>();

        public VendingMachineBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public VendingMachineBuilder withItem(int code, Item item) {
            this.items.put(code, item);
            return this;
        }

        public VendingMachine build() {
            return new VendingMachine(money, items);
        }
    }

    public static class ItemNotFound extends RuntimeException {}
    public static class InsufficientFunds extends RuntimeException {}
    public static class NotEnoughChange extends RuntimeException {}
}
