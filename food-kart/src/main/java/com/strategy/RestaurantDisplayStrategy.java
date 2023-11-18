package com.strategy;

import com.model.Restaurant;
import com.model.User;

import java.util.List;

public interface RestaurantDisplayStrategy {
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser);
}
