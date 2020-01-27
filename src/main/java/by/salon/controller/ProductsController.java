package by.salon.controller;

import by.salon.entity.AppUser;
import by.salon.entity.Order;
import by.salon.entity.Product;
import by.salon.entity.WeedingOrder;
import by.salon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Request;
import java.net.URLEncoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/products")
@SessionAttributes(types = AppUser.class)
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/dresses")
    public String getDresses(Model model){

        model.addAttribute("products", productsService.getAllDresses());
        model.addAttribute("colors", productsService.getAllColors());
        return "products";
    }

    @RequestMapping("/accessories")
    public String getAccessories(Model model){
        model.addAttribute("products", productsService.getAllAccessories());
        model.addAttribute("colors", productsService.getAllColors());
        return "products";
    }

    @RequestMapping("/buy/{id}")
    public String addOrder(@PathVariable Long id, Model model){

        Product product = productsService.getProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("customers", productsService.getAllUsers());
        return "product";
    }

    @RequestMapping("/addOrder")
    public String getHome(@ModelAttribute WeedingOrder weedingOrder, Model model){

        String productName = URLEncoder.encode(weedingOrder.getProductName(), StandardCharsets.UTF_8);

        String login = weedingOrder.getLogin();

        System.out.println(productName);

        Product product = productsService.getProductByName(productName);
        AppUser appUser = productsService.getUserByLogin(login);
        AppUser adminReg = productsService.getAdmin();

        Order order = new Order();
        order.setClientId((int)appUser.getAppUserId());
        order.setMasterId((int)adminReg.getAppUserId());
        order.setProductId((int)product.getProductId());

        productsService.saveOrder(order);

        return "home";
    }
}
