package entities;
import java.util.Objects;
/**
 * Predstavlja vozace
 *
 * Nasledjuje osobine osobe (Person) i implementira sučelje BusDriver.
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public class Driver extends Person implements BusDriver{
    private String username;
    private String password;
    private String role;
    /**
     *  kreira vozaca koristeci Builder obrazac.
     * @param builder Instanca DriverBuilder koja sadrzi informacije o vozacu.
     */
    public Driver(DriverBuilder builder) {
        super(builder.name, builder.surname, builder.age);
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
    }

    /**
     * Vraca korisnicko ime vozaca.
     * @return Korisnicko ime vozaca.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Vraca lozinku vozaca.
     * @return Lozinka vozaca.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Vraca ulogu vozaca.
     * @return Uloga vozaca.
     */
    public String getRole() {
        return role;
    }
    /**
     * Builder klasa za kreiranje instanci Driver koristeci Builder obrazac.
     */
    public static class DriverBuilder {
        private String name;
        private String surname;
        private Integer age;
        private String username="";
        private String password="";
        private String role="";

        /**
         * Postavlja ime vozaca.
         * @param name Ime vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setName(String name) {
            this.name = name;
            return this;
        }
        /**
         * Postavlja prezime vozaca.
         * @param surname Prezime vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        /**
         * Postavlja godine vozaca.
         * @param age Godine vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }
        /**
         * Postavlja korisnicko ime vozaca.
         * @param username Korisnicko ime vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setUsername(String username) {
            this.username = username;
            return this;
        }
        /**
         * Postavlja lozinku vozaca.
         * @param password Lozinka vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        /**
         * Postavlja ulogu vozaca.
         * @param role Uloga vozaca.
         * @return Instanca DriverBuilder za dalje postavljanje atributa.
         */
        public DriverBuilder setRole(String role) {
            this.role = role;
            return this;
        }
        /**
         * Kreira i vraca instancu Driver koristeci postavljene atribute.
         * @return Nova instanca Driver.
         */
        public Driver build() {
            return new Driver(this);
        }
    }

    @Override
    public void driveBus() {
        if (role.equals(BusDriver.vozacBus)){
            System.out.println("Vozac busa "+getName()+" "+getSurname()+" je poceo voziti bus.");
        }
    }
    @Override
    public void parkBus() {
        if (role.equals(BusDriver.vozacBus)){
            System.out.println("Vozac busa "+getName()+" "+getSurname()+" je parkirao bus.");
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Driver vozac = (Driver) obj;
        return Objects.equals(username, vozac.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return this.getName()+" "+this.getSurname()+" "+this.getAge();
    }
}
