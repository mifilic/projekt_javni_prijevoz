package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *Predstavlja rutu javnog prijevoza
 *
 *
 * sadrzi informacije o pocetnoj i krajnjoj stanici,te broju stanica izmedju njih
 * te vozilima koja voze na toj ruti
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 *
 */

public class Route {
    private String startStation;
    private String endStation;
    private Integer numberOfStops;
    private Integer numberOfVehicles = 0;
    private List<Vehicle> vehicles;

    /**
     * kreira rute sa specificiranom pocetnom i krajnjom stanicom te brojem stanica izmedju njih.
     * @param startStation Pocetna stanica rute.
     * @param endStation Krajnja stanica rute.
     * @param numberOfStops Broj stanica izmedju pocetne i krajnje stanice.
     */
    public Route(String startStation, String endStation, Integer numberOfStops) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.numberOfStops = numberOfStops;
    }
    /**
     * Kreira rutu kojoj dodjeljuje maksimalni broj vozila.
     *
     */
    public Route(){
        this.vehicles = new ArrayList<>();
    }

    /**
     * Vraća broj vozila na ruti.
     * @return Broj vozila na ruti.
     */
    public Integer getNumberOfVehicles() {
        return numberOfVehicles;
    }

    /**
     * Vraća vozila na ruti.
     * @return Niz vozila na ruti.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    /**
     * Postavlja vozila na rutu.
     *
     * @param vehicle Niz vozila koja se postavljaju na rutu.
     */
    public void setVehicles(Set<Vehicle> vehicle) {
        for (Vehicle v : vehicle) {
            Vehicle privremeni = new Vehicle();
            privremeni.setDrivers(v.getDrivers());
            privremeni.setNumberOfDrivers(v.getNumberOfDrivers());
            privremeni.setRegistrationNumber(v.getRegistrationNumber());
            privremeni.setType(v.getType());
            privremeni.setCapacity(v.getCapacity());
            vehicles.add(privremeni);
            numberOfVehicles++;
        }
    }

    /**
     * Dodaje vozilo na rutu.
     * @param vehicle Vozilo koje se dodaje na rutu.
     */
    public void addVehicle(Vehicle vehicle) {
        Vehicle privremeni = new Vehicle();
        privremeni.setDrivers(vehicle.getDrivers());
        privremeni.setNumberOfDrivers(vehicle.getNumberOfDrivers());
        privremeni.setRegistrationNumber(vehicle.getRegistrationNumber());
        privremeni.setType(vehicle.getType());
        privremeni.setCapacity(vehicle.getCapacity());
        vehicles.add(privremeni);
        numberOfVehicles++;
    }

    /**
     * Vraća pocetnu stanicu rute.
     * @return Pocetna stanica rute.
     *
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * Postavlja pocetnu stanicu rute.
     * @param startStation Nova pocetna stanica rute.
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    /**
     * Vraća krajnju stanicu rute.
     * @return Krajnja stanica rute.
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * Postavlja krajnju stanicu rute.
     * @param endStation Nova krajnja stanica rute.
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
    /**
     * Vraća broj stanica izmedju pocetne i krajnje stanice rute.
     * @return Broj stanica izmedju pocetne i krajnje stanice rute.
     */
    public Integer getNumberOfStops() {
        return numberOfStops;
    }
    /**
     * Postavlja broj stanica izmedju pocetne i krajnje stanice rute.
     * @param numberOfStops Novi broj stanica izmedju pocetne i krajnje stanice rute.
     */
    public void setNumberOfStops(Integer numberOfStops) {
        this.numberOfStops = numberOfStops;
    }
}
