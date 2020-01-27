package by.salon.repository;

import by.salon.entity.Color;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColorRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_ALL_FROM_COLORS = "from Color";

    public List<Color> getAllColors() {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_ALL_FROM_COLORS, Color.class)
                .list();
    }
}
