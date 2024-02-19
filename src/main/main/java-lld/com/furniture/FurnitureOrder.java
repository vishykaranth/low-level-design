package com.furniture;


import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private HashMap<Furniture, Integer> orders;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        orders = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        orders.put(type, furnitureCount);
        System.out.println(orders);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return orders;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float cost = 0;
        for (Furniture furniture : orders.keySet()) {
            cost += getTypeCost(furniture);
        }
        return cost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        int quantity = 0;
        String label = type.label();
        for (Furniture furniture : orders.keySet()) {
            if (label.equals(furniture.label())) {
                Integer integer = orders.get(furniture);
                quantity += integer;
            }
        }
        return quantity;
    }

    public float getTypeCost(Furniture type) {

        int quantity = 0;
        String label = type.label();
        for (Furniture furniture : orders.keySet()) {
            if (label.equals(furniture.label())) {
                Integer integer = orders.get(furniture);
                quantity += integer;
            }
        }
        return quantity * type.cost();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int quantity = 0;
        for (Integer a : orders.values()) {
            quantity += a;
        }
        return quantity;
    }
}