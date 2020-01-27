package by.salon.repository;

import by.salon.entity.Order;
import by.salon.entity.WeedingOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeedingOrderRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_ALL_FROM_WEEDING_ORDER = "from Order";

    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_ALL_FROM_WEEDING_ORDER, Order.class)
                .list();
    }
}
