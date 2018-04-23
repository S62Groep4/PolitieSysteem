package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.mindrot.jbcrypt.BCrypt;

@Entity
//NamedQueries
@NamedQueries({
@NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User u WHERE u.email LIKE :email")})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    
    private static final int workload = 12;
    private static final String salt = BCrypt.gensalt(workload);

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    // </editor-fold>
    
    public User(){
        
    }
    
    public User(String email, String password){
        this.email = email;
        this.password = BCrypt.hashpw(password, salt);
    }
    
    

}
