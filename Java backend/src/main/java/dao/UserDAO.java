package dao;

import domain.User;
import java.util.List;


public interface UserDAO {
    
    List<User> getUserByEmail(String email);

}
