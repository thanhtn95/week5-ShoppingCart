package service.impl;

import model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ShoppingCartRepository;
import service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findLast() {
        return shoppingCartRepository.findTopByOrderByIdDesc();
    }
}
