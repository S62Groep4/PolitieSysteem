package dao;

import domain.User;
import java.util.List;
import javax.persistence.EntityManager;


public class UserDAOImpl implements UserDAO{

    //PersistenceContext
    EntityManager em;
    
    @Override
    public List<User> getUserByEmail(String email) {
        return em.createNamedQuery("User.getByEmail").setParameter("email", email).getResultList();
    }

}
