package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.VehicleDAO;
import dao.VehicleEuropolDAO;
import domain.Journey;
import domain.SubInvoice;
import domain.Vehicle;
import domain.VehicleEuropol;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author Teun
 */
@Stateless
public class VehicleService {

    @Inject
    VehicleDAO vehicleDao;
    
    @Inject
    VehicleEuropolDAO vehicleEuropolDAO;

    private static final Logger LOGGER = Logger.getLogger(VehicleService.class.getName());

    public VehicleService() {
    }

    public Vehicle getVehicle(String hashedLicenceplate, boolean hashed) throws PersistenceException {
        try {
            return vehicleDao.getVehicle(hashedLicenceplate, hashed);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Vehicle> getSearchedVehicles(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getSearchedVehicles(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<SubInvoice> getVehicleInvoices(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleInvoices(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleInvoices operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getVehicleJourneys(String hashedLicenceplate) throws PersistenceException {
        try {
            return vehicleDao.getVehicleJourneys(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getVehicleJourneys operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Vehicle> getAllVehicles() throws PersistenceException {
        try {
            return vehicleDao.getAllVehicles();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllVehicles operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Vehicle updateVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            return vehicleDao.updateVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeVehicle(String hashedLicenceplate) throws PersistenceException {
        try {
            vehicleDao.removeVehicle(hashedLicenceplate);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeVehicle operation; {0}", pe.getMessage());
        }
    }

    public Vehicle insertVehicle(Vehicle vehicle) throws PersistenceException {
        try {
            VehicleEuropol stolenVehicle = new VehicleEuropol();
            stolenVehicle.setLicensePlate(vehicle.getLicencePlate());
            stolenVehicle.setOriginCountry("DE");
            stolenVehicle.setSerialNumber("Testing Serial number");//"c99459ba-4aea-4eac-bd3f-a5f4673ab3cd");
            stolenVehicle.setUrl("Testing url");
            addVehicleToEuropol(stolenVehicle);
            vehicleEuropolDAO.insertStolenVehicle(stolenVehicle);
            return null;//vehicleDao.insertVehicle(vehicle);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertVehicle operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void addVehicleToEuropol(VehicleEuropol stolenVehicle) {
        try {

            String url = "http://192.168.24.101:8000/api/v2/vehicles/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-type", "application/json");

            String urlParameters = "{\"url\":\"" + stolenVehicle.getUrl()
                    + "\",\"licensePlate\":\"" + stolenVehicle.getLicensePlate() + ""
                    + "\",\"serialNumber\":\"" + stolenVehicle.getSerialNumber() + ""
                    + "\",\"originCountry\":\"" + stolenVehicle.getOriginCountry() + "\"}";

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            //System.out.println("\nSending 'POST' request to URL : " + url);
            //System.out.println("Post parameters : " + urlParameters);
            //System.out.println("Response Code : " + responseCode);
            System.out.println("Adding stolen vehicle to Europol system");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
