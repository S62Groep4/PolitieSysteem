package service;

import dao.UserDAO;
import domain.User;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class init {
    
    @Inject
    UserDAO userDAO;
    
    @PostConstruct
    public void Init(){
        System.out.println("Hello");
        User testUser = new User("Medewerker@mail.com", "1234");
        userDAO.insertUser(testUser);
    }

}
