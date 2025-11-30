package entities.AppClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Predstavlja vozilo koje sadrzi svojstva i metode vezane za vozilo.
 */

public non-sealed class Vehicle implements Train, Serializable {
    private Integer brojVagona;
    private List<Driver> drivers;
    private Integer numberOfDrivers=0;
    private  String registrationNumber;
    private  String type;
    private Integer capacity;

    /**
     * Kreiranje vozila sa zadatim parametrima.
     *
     * @param registrationNumber Registracijski broj vozila.
     * @param type               Tip vozila.
     * @param capacity           Kapacitet vozila.
     */
    public Vehicle(String registrationNumber, String type, Integer capacity) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.capacity = capacity;
    }
    /**
     * Podrazumijevano konstruiranje vozila.
     */
    public Vehicle(){
        this.drivers = new ArrayList<>();
    }

    /**
     * Dohvaća broj vozaca povezanih sa vozilom.
     * @return Broj vozaca.
     */
    public Integer getNumberOfDrivers() {
        return numberOfDrivers;
    }
    /**
     * Postavlja broj vozaca povezanih sa vozilom.
     * @param numberOfDrivers Broj vozaca.
     */
    public void setNumberOfDrivers(Integer numberOfDrivers) {
        this.numberOfDrivers = numberOfDrivers;
    }
    /**
     * Dohvaća listu vozaca povezanih sa vozilom.
     * @return Lista vozaca.
     */
    public List<Driver> getDrivers() {
        return drivers;
    }
    /**
     * Postavlja listu vozaca povezanih sa vozilom.
     * @param driver Set vozaca.
     */
    public void setDrivers(Set<Driver> driver) {
        for (Driver a : driver) {
            drivers.add(new Driver.DriverBuilder()
                            .setName(a.getName())
                            .setSurname(a.getSurname())
                            .setAge(a.getAge())
                            .setUsername(a.getUsername())
                            .setPassword(a.getPassword())
                            .setRole(a.getRole())
                            .build());
            numberOfDrivers++;
        }
    }
    public void setDrivers(List<Driver> driver) {
        for (Driver a : driver) {
            drivers.add(new Driver.DriverBuilder()
                    .setName(a.getName())
                    .setSurname(a.getSurname())
                    .setAge(a.getAge())
                    .setUsername(a.getUsername())
                    .setPassword(a.getPassword())
                    .setRole(a.getRole())
                    .build());
            numberOfDrivers++;
        }
    }
    /**
     * Dodaje vozaca u listu vozaca povezanih sa vozilom.
     * @param driver Vozac koji se dodaje.
     */
    public void addDriver(Driver driver) {
        drivers.add(new Driver.DriverBuilder()
                .setName(driver.getName())
                .setSurname(driver.getSurname())
                .setAge(driver.getAge())
                .setUsername(driver.getUsername())
                .setPassword(driver.getPassword())
                .setRole(driver.getRole())
                .build());
        numberOfDrivers++;
    }
    /**
     * Dohvaća registracijski broj vozila.
     * @return Registracijski broj.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    /**
     * Postavlja registracijski broj vozila.
     * @param registrationNumber Registracijski broj.
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    /**
     * Dohvaća tip vozila.
     * @return Tip vozila.
     */
    public String getType() {
        return type;
    }
    /**
     * Postavlja tip vozila.
     * @param type Tip vozila.
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Dohvaća kapacitet vozila.
     * @return Kapacitet vozila.
     */
    public Integer getCapacity() {
        return capacity;
    }
    /**
     * Postavlja kapacitet vozila.
     * @param capacity Kapacitet vozila.
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    @Override
    public void ukljuciVlak() {
        if (type.equals(Train.ime)){
            System.out.println("Ovo vozilo je vlak i ukljuceno je");
        }
        else {
            System.out.println("Ovo vozilo nije vlak i ne moze biti ukljuceno kao vlak");
        }
    }
    @Override
    public void iskljuciVlak() {
        if (type.equals(Train.ime)){
            System.out.println("Ovo vozilo je vlak i iskljuceno je");
        }
        else {
            System.out.println("Ovo vozilo nije vlak i ne moze biti iskljuceno kao vlak");
        }
    }
    @Override
    public void dodajVagon() {
            brojVagona++;
    }
    @Override
    public void ukloniVagon() {
            brojVagona--;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vehicle vozilo = (Vehicle) obj;
        return Objects.equals(registrationNumber, vozilo.registrationNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
