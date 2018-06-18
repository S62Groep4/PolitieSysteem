/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.VehicleEuropolDAO;
import domain.VehicleEuropol;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class VehicleEuropolService {

    @Inject
    VehicleEuropolDAO vehicleEuropolDAO;

    public List<VehicleEuropol> getStolenVehicles() throws PersistenceException {
        return vehicleEuropolDAO.getStolenVehicles();
    }

    public VehicleEuropol findStolenVehicle(String licensePlate) throws PersistenceException {
        return vehicleEuropolDAO.findStolenVehicle(licensePlate);
    }

    public VehicleEuropol insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return vehicleEuropolDAO.insertStolenVehicle(vehicleEuropol);
    }

    public VehicleEuropol insertStolenEuropolVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        vehicleEuropol.setOriginCountry("DE");
        String url = "http://192.168.24.101:8000/api/v2/vehicles/" + vehicleEuropol.getSerialNumber() + "/";
        vehicleEuropol.setUrl(url);

        addVehicleToEuropol(vehicleEuropol);
        
        return vehicleEuropolDAO.insertStolenVehicle(vehicleEuropol);
    }

    public VehicleEuropol updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        return vehicleEuropolDAO.updateStolenVehicle(vehicleEuropol);
    }

    public void removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        vehicleEuropolDAO.removeStolenVehicle(vehicleEuropol);
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
