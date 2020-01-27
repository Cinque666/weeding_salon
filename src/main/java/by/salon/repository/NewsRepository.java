package by.salon.repository;

import by.salon.entity.News;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<News> getFourNews() {
        return sessionFactory.getCurrentSession()
                .createQuery("from News", News.class)
                .setMaxResults(4)
                .list();
    }
}
