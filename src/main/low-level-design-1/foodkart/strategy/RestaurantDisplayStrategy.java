package foodkart.strategy;

import foodkart.model.Restaurant;
import foodkart.model.User;

import java.util.List;

public interface RestaurantDisplayStrategy {
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser);
}
