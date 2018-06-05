package rest;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface JWTokenNeeded {
    /*
    Place this token on any RESTful method that needs authentication that a verified user is behind it.
    The annotation fires the filter method from the JWTFilter class.
     */
}
