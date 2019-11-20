package controller;

import model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ShoppingCartService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CartControllers {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("/newCart")
    private ModelAndView addNeWCart(){
        shoppingCartService.save(new ShoppingCart());
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
}
