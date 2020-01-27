package by.salon.repository;

import by.salon.entity.FeedBack;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedBackRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(FeedBack feedBack) {
        sessionFactory.getCurrentSession()
                .save(feedBack);
    }
}
