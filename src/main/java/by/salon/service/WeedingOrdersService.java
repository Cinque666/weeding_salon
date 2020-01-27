package by.salon.service;

import by.salon.entity.AppUser;
import by.salon.entity.Order;
import by.salon.entity.Product;
import by.salon.entity.WeedingOrder;
import by.salon.repository.AppUserRepository;
import by.salon.repository.ProductRepository;
import by.salon.repository.WeedingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeedingOrdersService {


    @Autowired
    private WeedingOrderRepository weedingOrderRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Order> getAllOrders() {
        return weedingOrderRepository.getAllOrders();
    }

    @Transactional
    public List<AppUser> getAllUsers() {
        return appUserRepository.getAllUsers();
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
