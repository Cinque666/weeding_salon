package by.salon.repository;

import by.salon.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_FROM_PRODUCT_WHERE_PRODUCT = "from Product where productTypeId = :param";
    private static final String SELECT_FROM_PRODUCT_WHERE_PRODUCT_ID = "from Product where productId = :param";
    private static final String SELECT_FROM_PRODUCT_WHERE_NAME_LIKE = "from Product where name like :param";

    public List<Product> getAllDresses() {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_PRODUCT_WHERE_PRODUCT, Product.class)
                .setParameter("param", 2)
                .list();
    }

    public Product getProductById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_PRODUCT_WHERE_PRODUCT_ID, Product.class)
                .setParameter("param", id)
                .getSingleResult();
    }

    public void save(Product product) {
        sessionFactory.getCurrentSession()
                .save(product);
    }

    public List<Product> getAllAccessories() {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_PRODUCT_WHERE_PRODUCT, Product.class)
                .setParameter("param", 1)
                .list();
    }

    public Product getProductByName(String productName) {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_PRODUCT_WHERE_NAME_LIKE, Product.class)
                .setParameter("param", productName)
                .getSingleResult();
    }

    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product", Product.class)
                .list();
    }
}
