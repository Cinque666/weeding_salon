package by.salon.repository;

import by.salon.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order) {
        sessionFactory.getCurrentSession()
                .save(order);
    }
}
