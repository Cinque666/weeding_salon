package by.salon.service;

import by.salon.controller.ProductController;
import by.salon.entity.Product;
import by.salon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductItem(Long id) {
        return productRepository.getProductById(id);
    }
}
