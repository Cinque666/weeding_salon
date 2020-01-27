package by.salon.controller;

import by.salon.entity.AppUser;
import by.salon.entity.Order;
import by.salon.entity.Product;
import by.salon.entity.WeedingOrder;
import by.salon.service.WeedingOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/weedingOrders")
public class WeedingOrdersController {


    @Autowired
    private WeedingOrdersService weedingOrdersService;

    @RequestMapping(method = RequestMethod.GET)
    public String getWeedingOrders(Model model){

        List<Order> orders = weedingOrdersService.getAllOrders();
        List<AppUser> appUsers = weedingOrdersService.getAllUsers();
        List<Product> products = weedingOrdersService.getAllProducts();

        model.addAttribute("orders", orders);
        model.addAttribute("appUsers", appUsers);
        model.addAttribute("products", products);

        return "weedingOrders";
    }

}
