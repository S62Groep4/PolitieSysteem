package rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeaderValue = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        if(authHeaderValue == null){
            throw new WebApplicationException("Authorization header was not set", 401);
        }
        
        String jsonWebToken = authHeaderValue.substring("Bearer".length()).trim();
        
        try{
            Algorithm alg = Algorithm.HMAC512("Proftaak");
            JWTVerifier jwtVerifier = JWT.require(alg).withIssuer("Duitsland").build();
            
            DecodedJWT decodedToken = jwtVerifier.verify(jsonWebToken);
            String userName = decodedToken.getSubject();
            SecurityContext sc = requestContext.getSecurityContext();
            requestContext.setSecurityContext(
            new SecurityContext(){

                @Override
                public Principal getUserPrincipal() {
                    return () -> userName;
                }

                @Override
                public boolean isUserInRole(String string) {
                    return true;
                }

                @Override
                public boolean isSecure() {
                    return sc.isSecure();
                }

                @Override
                public String getAuthenticationScheme() {
                    return "Bearer";
                }
            });
        }catch(UnsupportedEncodingException ex){
            //TODO; handle errors
        }
    }

}
