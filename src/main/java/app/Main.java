
package app;
import entities.AppClasses.*;
import entities.Enums.*;
import entities.Services.JsonService;
import entities.Services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Program je pokrenut.");
        Service service = new Service(log);
        JsonService jsonService = new JsonService(log);
        Set<Driver> vozaci = new LinkedHashSet<>();
        Set<Passenger> putnici = new LinkedHashSet<>();
        Set<Conductor> kondukteri = new LinkedHashSet<>();
        Set<Route> rute = new LinkedHashSet<>();
        Set<Vehicle> vozila = new LinkedHashSet<>();
        Scanner sc = new Scanner(System.in);
        Integer provjera;

        System.out.println("Upisi 1 za pronalazak info o vozacima na određenoj ruti ili 0 za daljnje pretrazivanje: ");
        while (true) {
            try {
                provjera = sc.nextInt();
                if (provjera == 0 || provjera == 1) {
                    break;
                } else if (provjera < 0) {
                    service.provjerakoda(provjera);
                }
            } catch (InputMismatchException | entities.Exceptions.NegativeNumException e) {
                log.error("Pogresan unos podataka.", e);
                System.out.println("Pogresan unos. Mora se unijeti broj i ne smije biti negativan. Unesite 1 ili 0:");
                sc.nextLine();
            }
        }
        sc.nextLine();
        service.InfoVozac(provjera, sc, rute);

        Optional<Route> najkraca = service.najkracaRuta(rute);
        if (najkraca.isPresent()) {
            log.info("Najkraca ruta je pronadena.");
            System.out.println("Najkraca ruta je od " + najkraca.get().getStartStation() + " do " + najkraca.get().getEndStation() + " sa " + najkraca.get().getNumberOfStops() + " stanica.");
        } else {
            log.warn("Nije pronadena najkraca ruta.");
        }

        Optional<Vehicle> najmanji = service.najmKapacitet(vozila);
        if (najmanji.isPresent()) {
            log.info("Vozilo sa najmanjim kapacitetom je pronadeno.");
            System.out.println("Vozilo sa najmanjim kapacitetom je registracije " + najmanji.get().getRegistrationNumber() + " sa kapacitetom od " + najmanji.get().getCapacity() + ".");
        } else {
            log.warn("Nije pronadeno vozilo sa najmanjim kapacitetom.");
        }
        sc.close();
    }
}
