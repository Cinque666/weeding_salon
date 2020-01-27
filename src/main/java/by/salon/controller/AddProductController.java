package by.salon.controller;

import by.salon.entity.Product;
import by.salon.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/add")
public class AddProductController {

    @Autowired
    private AddProductService addProductService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAddPage(Model model){
        return "addProduct";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addNewProduct(@ModelAttribute("product") Product product,
                                @RequestParam("image") MultipartFile file,
                                Model model) throws IOException {
        if (!file.isEmpty() && product != null) {
            byte[] bytes = file.getBytes();
            product.setImage(bytes);
            addProductService.saveNewProduct(product);
            return "/home";
        }
        return "error";
    }
}
