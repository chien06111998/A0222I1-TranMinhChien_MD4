package com.example.gio_hang.controller;

import com.example.gio_hang.model.Cart;
import com.example.gio_hang.model.Product;
import com.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/cart/list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart/view");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}
