package service;

import model.ShoppingCart;

public interface ShoppingCartService {
    void save(ShoppingCart shoppingCart);
    ShoppingCart findLast();
}
