package repository;

import model.ProductOrderDetail;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductOrderDetailRepository extends PagingAndSortingRepository<ProductOrderDetail,Integer> {
}
