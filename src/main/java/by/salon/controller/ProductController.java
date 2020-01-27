package by.salon.controller;

import by.salon.entity.Product;
import by.salon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;
    //C:\javaprojects\weeding\gepard.jpg

    @GetMapping("/item/{id}")
    public String showProductItem(@PathVariable Long id, Model model) {
        Product productItem = productService.getProductItem(id);
        model.addAttribute("item", productItem);
        File image = new File("C:\\javaprojects\\weeding\\gepard.jpg");
        return "productItemPage";
    }

    @GetMapping("item/{id}/image")
    public @ResponseBody byte[]showProductImage(@PathVariable Long id) {
        return productService.getProductItem(id).getImage();
    }

}
