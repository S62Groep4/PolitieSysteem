/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.VehicleEuropol;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class VehicleEuropolDAOImpl implements VehicleEuropolDAO {

    @PersistenceContext(name = "ptt_test")
    EntityManager em;

    @Override
    public List<VehicleEuropol> getStolenVehicles() throws PersistenceException {
        return em.createNamedQuery("VehicleEuropol.getStolenVehicles").getResultList();
    }

    @Override
    public VehicleEuropol findStolenVehicle(String licensePlate) throws PersistenceException {
        return (VehicleEuropol) em.createNamedQuery("VehicleEuropol.findStolenVehicle").setParameter("licensePlate", licensePlate).getSingleResult();
    }

    @Override
    public Boolean insertStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        em.persist(vehicleEuropol);
        return true;
    }

    @Override
    public Boolean updateStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        em.merge(vehicleEuropol);
        return true;
    }

    @Override
    public Boolean removeStolenVehicle(VehicleEuropol vehicleEuropol) throws PersistenceException {
        VehicleEuropol tempVehicle = (VehicleEuropol) em.createNamedQuery("VehicleEuropol.findStolenVehicle").setParameter("licensePlate", vehicleEuropol.getLicensePlate()).getSingleResult();//em.find(VehicleEuropol.class, vehicleEuropol.getLicensePlate());
        removeVehicleFromEuropol(tempVehicle);
        em.remove(tempVehicle);
        return true;
    }

    public void removeVehicleFromEuropol(VehicleEuropol stolenVehicle) {
        try {
            URL url = new URL("http://192.168.24.101:8000/api/v2/vehicles/" + stolenVehicle.getSerialNumber() + "/");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setRequestMethod("DELETE");
            httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //System.out.println("URL info: " + url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Removing stolen vehicle from Europol system");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
