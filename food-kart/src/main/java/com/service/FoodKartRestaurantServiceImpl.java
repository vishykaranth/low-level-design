package com.service;

import com.dao.RestaurantDao;
import com.dao.UserDao;
import com.model.Restaurant;
import com.strategy.PriceStrategy;
import com.strategy.RatingStrategy;
import com.strategy.RestaurantDisplayStrategy;

import java.util.ArrayList;
import java.util.List;

public class FoodKartRestaurantServiceImpl implements FoodKartRestaurantService {
    RestaurantDao restaurantDao;
    UserDao userDao;

    public FoodKartRestaurantServiceImpl() {
        this.restaurantDao = RestaurantDao.getInstance();
        this.userDao = UserDao.getInstance();
    }

    @Override
    public void registerRestaurant(String restaurantName, String listOfPincodes, String foodName, double price,
        int quantity) {
        Restaurant restaurant = new Restaurant(restaurantName, listOfPincodes.split("[/]"), foodName, price, quantity);
        this.restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public boolean updateQuantity(String restaurantName, int quantityToAdd) {
        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        if (restaurant != null) {
            restaurant.updateQuantity(quantityToAdd);
            return true;
        }
        return false;
    }

    @Override
    public void rateRestaurant(String restaurantName, int rating, String comment) {
        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        restaurant.addComments(rating, comment);
    }

    @Override
    public List<Restaurant> showRestaurant(String sortBy) {
        RestaurantDisplayStrategy strategy = null;
        if (sortBy.equals("rating")) {
            strategy = new RatingStrategy();
        }
        if (sortBy.equals("price")) {
            strategy = new PriceStrategy();
        }
        if (strategy != null)
            return strategy.findRestaurants(restaurantDao.getListOfRestaurants(), userDao.getCurrentLoginUser());
        return new ArrayList<>();
    }

    @Override
    public boolean placeOrder(String restaurantName, int quantity) {
        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        if (restaurant != null) {
            return restaurant.placeOrder(quantity);
        }
        return false;
    }
}
