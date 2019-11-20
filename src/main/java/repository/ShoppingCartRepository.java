package repository;

import model.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShoppingCartRepository extends PagingAndSortingRepository<ShoppingCart,Integer> {
    ShoppingCart findTopByOrderByIdDesc();
}
