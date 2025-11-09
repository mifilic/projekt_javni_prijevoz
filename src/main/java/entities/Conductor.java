package entities;

import java.util.Objects;

/**
 * Predstavlja konduktera u sistemu javnog prevoza.
 *
 * Nasledjuje osobine osobe (Person) i dodaje specificne atribute i metode za konduktera.
 *
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public class Conductor extends Person{
    private String username="";
    private String password="";
    private Integer numberOfAssignedVehicles=0;
    /**
     *  kreirakonduktera sa osnovnim informacijama.
     *
     * @param name Ime konduktera.
     * @param surname Prezime konduktera.
     * @param age Godine konduktera.
     */
    public Conductor(String name, String surname, Integer age) {
        super(name, surname, age);
    }
    /**
     * Vraca korisnicko ime konduktera.
     * @return Korisnicko ime konduktera.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Postavlja korisnicko ime konduktera.
     * @param username Korisnicko ime koje se postavlja.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Vraca lozinku konduktera.
     * @return Lozinka konduktera.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Postavlja lozinku konduktera.
     * @param password Lozinka koja se postavlja.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Vraca broj vozila dodijeljenih kondukteru.
     * @return Broj dodeljenih vozila.
     */
    public Integer getNumberOfAssignedVehicles() {
        return numberOfAssignedVehicles;
    }
    /**
     * Postavlja broj vozila dodijeljenih kondukteru.
     * @param num Broj vozila koji se postavlja.
     */
    public void setNumberOfAssignedVehicles(Integer num) {
        this.numberOfAssignedVehicles = num;
    }
    /**
     * Povecava broj dodijeljenih vozila za jedan.
     */
    public void addAssignedVehicle() {
        this.numberOfAssignedVehicles++;
    }
    /**
     * Smanjuje broj dodijeljenih vozila za jedan, ako je broj veci od nule.
     */
    public void removeAssignedVehicle() {
        if (this.numberOfAssignedVehicles>0) {
            this.numberOfAssignedVehicles--;
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Conductor kond = (Conductor) obj;
        return Objects.equals(username, kond.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
