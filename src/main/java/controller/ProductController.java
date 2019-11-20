package controller;

import model.Product;
import model.ProductOrderDetail;
import model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;
import service.ShoppingCartService;

import java.util.Optional;

@Controller

public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @ModelAttribute("currentCart")
    private ShoppingCart currentCart(){
        return shoppingCartService.findLast();
    }

    @GetMapping("")
    private ModelAndView getProductList(@PageableDefault(size = 5)Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/productList");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/{id}/viewProduct")
    private ModelAndView viewProduct(@PathVariable int id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/ProductAddToCartForm");
        modelAndView.addObject("currentCart",currentCart());
        modelAndView.addObject("product",product);
        modelAndView.addObject("productOrderDetail",new ProductOrderDetail());
        return modelAndView;
    }
}
