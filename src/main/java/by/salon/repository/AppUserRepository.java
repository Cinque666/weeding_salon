package by.salon.repository;

import by.salon.entity.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_FROM_APP_USER_WHERE_LOGIN_LIKE_PARAM = "from AppUser where login like :param";
    private static final String SELECT_ALL_FROM_APP_USER = "from AppUser";
    private static final String SELECT_FROM_APP_USER_WHERE_ID = "from AppUser where id = :param";

    public AppUser findUserByLogin(String username) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(SELECT_FROM_APP_USER_WHERE_LOGIN_LIKE_PARAM, AppUser.class)
                    .setParameter("param", username)
                    .getSingleResult();
        } catch (Exception e) {

            return null;
        }
    }

    public Integer findUserCountByLogin(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_APP_USER_WHERE_LOGIN_LIKE_PARAM, AppUser.class)
                .setParameter("param", username)
                .list()
                .size();
    }

    public void save(AppUser appUser){
        sessionFactory.getCurrentSession()
                .save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_ALL_FROM_APP_USER, AppUser.class)
                .list();
    }

    public AppUser findUserById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_APP_USER_WHERE_ID, AppUser.class)
                .setParameter("param", id)
                .getSingleResult();
    }

    public void upUser(AppUser appUser) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(appUser);
    }

    public void downUser(AppUser appUser) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(appUser);
    }

    public void delete(Long id) {
        AppUser appUser = new AppUser();
        appUser.setAppUserId(id);
        sessionFactory.getCurrentSession()
                .delete(appUser);
    }

    public AppUser getUserByLogin(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser where login like :param", AppUser.class)
                .setParameter("param", login)
                .getSingleResult();
    }

    public AppUser getAdmin() {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser where roleId = 1", AppUser.class)
                .list().get(0);
    }
}
