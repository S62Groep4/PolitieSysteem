package service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dao.UserDAO;
import domain.User;
import java.io.UnsupportedEncodingException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

@Stateless
public class LoginService {
    
    @Inject
    UserDAO userDAO;
    
    public boolean verifyLogin(String email, String password){
        System.out.println("Password : " + password);
        
        User user = userDAO.getUserByEmail(email).get(0);
        
        //Check if there is any result at all
        if(user == null){
            return false;
        }
        //Check if the email is the same as the set email and check if the password is correct.
        if(checkPassword(password, user.getPassword())){
            //Credentials are correct
            return true;
        }
        return false;
    }
    
    public String returnToken(String loginEmail){
        Algorithm alg;
        String token = "";
        
        try{
            alg = Algorithm.HMAC512("proftaak");
            //TODO; Expire date
            //Token over multiple applications
            token = JWT.create().withSubject(loginEmail).withIssuer("PolitieSysteem").sign(alg);
        }catch(UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
        
        return token;
    }
    
    private boolean checkPassword(String password, String hashedPassword){
        boolean state;
        
        if(hashedPassword == null || !hashedPassword.startsWith("$2a$")){
            return false;
        }
        
        state = BCrypt.checkpw(password, hashedPassword);
        return state;
    }

}
