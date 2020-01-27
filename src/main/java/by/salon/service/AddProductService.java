package by.salon.service;

import by.salon.entity.Product;
import by.salon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void saveNewProduct(Product product) {
        productRepository.save(product);
    }
}
