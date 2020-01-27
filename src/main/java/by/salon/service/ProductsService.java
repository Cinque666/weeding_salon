package by.salon.service;

import by.salon.entity.AppUser;
import by.salon.entity.Color;
import by.salon.entity.Order;
import by.salon.entity.Product;
import by.salon.repository.AppUserRepository;
import by.salon.repository.ColorRepository;
import by.salon.repository.OrderRepository;
import by.salon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Product> getAllDresses() {
        return productRepository.getAllDresses();
    }

    @Transactional
    public List<Color> getAllColors() {
        return colorRepository.getAllColors();
    }

    @Transactional
    public List<Product> getAllAccessories() {
        return productRepository.getAllAccessories();
    }

    @Transactional
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Transactional
    public List<AppUser> getAllUsers() {
        return appUserRepository.getAllUsers();
    }

    @Transactional
    public Product getProductByName(String productName) {
        return productRepository.getProductByName(productName);
    }

    @Transactional
    public AppUser getUserByLogin(String login) {
        return appUserRepository.getUserByLogin(login);
    }

    @Transactional
    public AppUser getAdmin() {
        return appUserRepository.getAdmin();
    }

    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
