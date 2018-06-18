package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import domain.VehicleEuropol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Teun
 */
@Startup
@Singleton
public class Init {

    @Inject
    VehicleService vehicleService;

    @Inject
    TransLocationService transLocationService;

    @Inject
    SubInvoiceService subInvoiceService;

    @Inject
    UserService userService;

    @Inject
    VehicleEuropolService vehicleEuropolService;

    @PostConstruct
    public void init() {
        getStolenVehicles();
        createAccount();
    }
    
    public void createAccount() {
        User user = new User("Medewerker@mail.com", "1234");
        
        userService.insertUser(user);
    }

    public void getStolenVehicles() {
        try {
            URL url = new URL("http://192.168.24.101:8000/api/v2/vehicles/?originCountry=DE");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            VehicleEuropol[] stolenVehicles = null;
            ObjectMapper objectMapper = new ObjectMapper();
            while ((output = br.readLine()) != null) {
                stolenVehicles = objectMapper.readValue(output, VehicleEuropol[].class);
            }

            for (int i = 0; i < stolenVehicles.length; i++) {
                vehicleEuropolService.insertStolenVehicle(stolenVehicles[i]);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
