package service.impl;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.ProductRopository;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRopository productRopository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRopository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return productRopository.findOne(id);
    }
}
