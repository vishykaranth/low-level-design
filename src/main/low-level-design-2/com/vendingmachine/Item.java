package com.vendingmachine;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private final String name;
    private final int price;

    public  Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

