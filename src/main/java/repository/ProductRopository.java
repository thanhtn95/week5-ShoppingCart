package repository;

import model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRopository extends PagingAndSortingRepository<Product,Integer> {
}
