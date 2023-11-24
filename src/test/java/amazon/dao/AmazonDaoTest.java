package amazon.dao;


import amazon.model.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AmazonDaoTest {


    @Test
    public void basicTests(){
        AmazonDao amazonDao = new AmazonDao();
        Category category = new Category("Shoes");
        amazonDao.addCategory(category);


        Product product = new Product("Runner Excel", category, 100.00, 20);
        Order order = new Order(product.getProductId(), 1, "BG JPN");
        User user = new Member();
        amazonDao.addOrderForUser(order, user.getUserId());

        amazonDao.addProduct(product);



        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, 2);
        amazonDao.addProductToShoppingCart(user.getUserId(), shoppingCartItem);
        amazonDao.decreaseQtyFromShoppingCart(user.getUserId(), product.getProductId());

        assertThat(amazonDao.getProduct(product.getProductId()).getProductId(), is(product.getProductId()));
    }

}