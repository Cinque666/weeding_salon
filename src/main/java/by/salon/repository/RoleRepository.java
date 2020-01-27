package by.salon.repository;

import by.salon.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;
    private static final String SELECT_FROM_ROLE_WHERE_ID = "from Role where roleId = :param";

    public Role getRoleById(long id){
        return sessionFactory.getCurrentSession()
                .createQuery(SELECT_FROM_ROLE_WHERE_ID, Role.class)
                .setParameter("param", id)
                .getSingleResult();
    }
}
