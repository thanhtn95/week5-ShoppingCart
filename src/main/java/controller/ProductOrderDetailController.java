package controller;

import model.ProductOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductOrderDetailService;

import java.util.ArrayList;

@Controller
@SessionAttributes("cartOrderList")
public class ProductOrderDetailController {
    @ModelAttribute("cartOrderList")
    private ArrayList<ProductOrderDetail> setUpOrderList(){
        return new ArrayList<ProductOrderDetail>();
    }
    @Autowired
    private ProductOrderDetailService productOrderDetailService;
    @PostMapping("/AddNewOrder")
    private ModelAndView doAddNewOrder(@ModelAttribute("productOrderDetail") ProductOrderDetail productOrderDetail, @ModelAttribute("cartOrderList") ArrayList<ProductOrderDetail> cartOrderList){
        for(int i = 0; i <cartOrderList.size();i++){
            if(cartOrderList.get(i).getProduct().getId() == productOrderDetail.getProduct().getId()){
                cartOrderList.get(i).setQuantity(cartOrderList.get(i).getQuantity()+ productOrderDetail.getQuantity());
                return new ModelAndView("redirect:/");
            }
        }
        cartOrderList.add(productOrderDetail);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/viewCart")
    private ModelAndView getCarts(@ModelAttribute("cartOrderList") ArrayList<ProductOrderDetail> cartOrderList){
        ModelAndView modelAndView = new ModelAndView("/cart/ViewCart");
        modelAndView.addObject("cartOrderList",cartOrderList);
        double totalBill = 0;
        for(ProductOrderDetail order: cartOrderList){
            totalBill+= order.getQuantity()* order.getProduct().getPrice();
        }
        modelAndView.addObject("totalBill", totalBill);
        return modelAndView;
    }

    @GetMapping("/{id}/RemoveFromCart")
    private ModelAndView modelAndView(@ModelAttribute("cartOrderList") ArrayList<ProductOrderDetail> cartOrderList, @PathVariable int id){
        int index = -1;
        for(int i = 0; i<cartOrderList.size();i++){
            if(cartOrderList.get(i).getId() == id){
                index = i;
                break;
            }
        }
        cartOrderList.remove(index);
        return new ModelAndView("redirect:/viewCart");
    }

    @GetMapping("/SaveCartOrder")
    private ModelAndView saveCartOrder(@ModelAttribute("cartOrderList") ArrayList<ProductOrderDetail> cartOrderList){
        for(ProductOrderDetail order: cartOrderList){
            productOrderDetailService.save(order);
        }
        return new ModelAndView("redirect:/viewCart");
    }
}
