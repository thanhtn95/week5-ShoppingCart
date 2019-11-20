package service.impl;

import model.ProductOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductOrderDetailRepository;
import repository.ProductRopository;
import service.ProductOrderDetailService;

public class ProductOrderDetailServiceImpl implements ProductOrderDetailService {

    @Autowired
    private ProductOrderDetailRepository productOrderDetailRepository ;
    @Override
    public void save(ProductOrderDetail productOrderDetail) {
        productOrderDetailRepository.save(productOrderDetail);
    }
}
