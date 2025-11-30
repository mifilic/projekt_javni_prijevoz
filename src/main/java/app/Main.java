package app;
import entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
/**
 * Glavna klasa aplikacije
 */

public class Main {
    static Logger log= LoggerFactory.getLogger(Main.class);

    static void main() {
        log.info("Program je pokrenut.");
        List<Person> potraga=new ArrayList<>();
        Set<Driver> vozaci =new HashSet<>();
        List<Passenger> putnici=new ArrayList<>();
        Set<Conductor> kondukteri=new HashSet<>();
        List<Route> rute =new ArrayList<>();
        Set<Vehicle> vozila =new HashSet<>();
        Scanner sc = new Scanner(System.in);
        Integer brojac=0;
        Integer provjera;
        for (Integer i = 0; i <Konstante.POLJA.getValue(); i++) {
            vozaci.add(ucitajVozace(sc));
        }
//        ispisiVozace(vozaci);
        for (Integer i = 0; i <Konstante.POLJA.getValue(); i++) {
            kondukteri.add(ucitajKonduktere(sc));
        }
        for (Driver d : vozaci) {
            potraga.add(new Driver.DriverBuilder()
                    .setName(d.getName())
                    .setSurname(d.getSurname())
                    .setAge(d.getAge())
                    .setUsername(d.getUsername())
                    .setPassword(d.getPassword())
                    .setRole(d.getRole())
                    .build());
            brojac++;
        }
        for (Conductor k : kondukteri) {
            potraga.add(new Conductor(k.getName(), k.getSurname(), k.getAge()));
            brojac++;
            ((Conductor) potraga.get(brojac - 1)).setUsername(k.getUsername());
            ((Conductor) potraga.get(brojac - 1)).setPassword(k.getPassword());
            ((Conductor) potraga.get(brojac - 1)).setNumberOfAssignedVehicles(k.getNumberOfAssignedVehicles());
        }
        najmladi(potraga);
        for (Integer i = 0; i <Konstante.POLJA.getValue() ; i++) {
            vozila.add(ucitajVozila(sc, vozaci));
        }
        for (Integer i = 0; i < Konstante.POLJA.getValue(); i++) {
            rute.add(ucitajRute(sc,vozila));
        }
        for (Integer i = 0; i < Konstante.POLJA.getValue(); i++) {
            putnici.add(upisiPutnike(sc));
        }
        System.out.println("Upisi 1 za pronalazak info o vozacima na određenoj ruti ili 0 za daljnje pretrazivanje: ");
        while (true) {
            try {
                provjera = sc.nextInt();
                if (provjera == 0 || provjera == 1) {
                    break;
                } else if(provjera<0){
                    provjerakoda(provjera);
                }
            } catch (InputMismatchException | NegativeNumException e) {
                log.error("Pogresan unos podataka.", e);
                System.out.println("Pogresan unos. Mora se unijeti broj i ne smije biti negativan. Unesite 1 ili 0:");
                sc.nextLine();
            }
        }
        sc.nextLine();
        InfoVozac(provjera,sc,rute);
        Optional<Route> najkraca=najkracaRuta(rute);
        if (najkraca.isPresent()) {
            log.info("Najkraca ruta je pronadena.");
            System.out.println("Najkraca ruta je od "+najkraca.get().getStartStation()+" do "+najkraca.get().getEndStation()+" sa "+najkraca.get().getNumberOfStops()+" stanica.");

        } else {
            log.warn("Nije pronadena najkraca ruta.");
        }
        Optional<Vehicle> najmanji=najmKapacitet(vozila);
        if (najmanji.isPresent()) {
            log.info("Vozilo sa najmanjim kapacitetom je pronadeno.");
            System.out.println("Vozilo sa najmanjim kapacitetom je registracije "+najmanji.get().getRegistrationNumber()+" sa kapacitetom od "+najmanji.get().getCapacity()+".");
        } else {
            log.warn("Nije pronadeno vozilo sa najmanjim kapacitetom.");
        }
        sc.close();
    }
    /**
     * provjerava ispravnost broja
     *
     * broj mora biti cijeli broj bez znakova
     *
     * @param br broj za provjeru
     * @throws InvalidNumException iznimka koja se baca ako broj nije ispravan
     */
    private static void provjeraNum(String br) throws InvalidNumException {

        try {
            Integer.parseInt(br);
        } catch (NumberFormatException e) {
            log.error("Pogresan unos broja.", e);
            throw new InvalidNumException("mora biti upisan broj bez znakova. Pokusajte ponovno.",e);
        }
    }
    private static void provjerakoda(Integer br){
        if(br<0){
            throw new NegativeNumException("Broj ne smije biti negativan. Pokusajte ponovno.");
        }
    }
    /**
     * provjerava ispravnost imena
     *
     * ime mora pocinjati velikim slovom te sva sljedeca slova moraju biti mala
     * ne smije sadrzavati brojeve ili posebne znakove
     *
     * @param ime ime za provjeru
     * @throws InvalidNameException iznimka koja se baca ako ime nije ispravno
     */
    private static void provjeraName(String ime) throws InvalidNameException {
        if (!ime.matches("^[A-ZČĆŽŠĐ][a-zčćžšđ]+$")) {
            throw new InvalidNameException("Ime mora pocinjati velikim slovom te sva sljedeca slova " +
                    "moraju biti mala. Ne smije sadrzavati brojeve ili posebne znakove. Pokusajte ponovno.");
        }
    }
    /**
     * učitava vozace
     *
     * upisuje ime, prezime, godine te username, password i ulogu vozacu
     *
     * @param sc scanner za unos podataka
     * @return objekt vozaca
     */
    private static Driver ucitajVozace(Scanner sc) {
        log.info("Ucitaj vozace metoda je pokrenuta.");
        String name;
        String surname;
        String username;
        String password;
        String role;
        String prov;
        Integer age;
        boolean provjera=true;
        System.out.println("Unesite ime vozaca:");
        name=sc.nextLine();
        while(provjera){
            try {
                provjeraName(name);
                provjera=false;
            }
            catch (InvalidNameException e) {
                log.debug("Pogresan unos broja.", e);
                System.out.println(e.getMessage());
                System.out.println("Unesite ime vozaca ponovo:");
                name=sc.nextLine();
            }
        }
        provjera=true;
        System.out.println("Unesite prezime vozaca:");
        surname=sc.nextLine();
        System.out.println("Unesite godine vozaca:");
        prov=sc.nextLine();
        while(provjera){
            try {
                provjeraNum(prov);
                provjera=false;
            }
            catch (InvalidNumException e) {
                log.debug("Pogresan unos broja.", e);
                System.out.println(e.getMessage());
                System.out.println("Unesite godine vozaca ponovo:");
                prov=sc.nextLine();
            }
        }
        age=Integer.parseInt(prov);
        System.out.println("Unesite username vozaca:");
        username=sc.nextLine();
        System.out.println("Unesite password vozaca:");
        password=sc.nextLine();
        System.out.println("Unesite ulogu vozaca:");
        role=sc.nextLine();
        System.out.println();
        log.info("Ucitaj vozace metoda je zavrsena.");
        return new Driver.DriverBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .setUsername(username)
                .setPassword(password)
                .setRole(role)
                .build();
    }
    /**
     * učitava konduktere
     *
     * upisuje ime, prezime, godine te username, password i broj dodijeljenih vozila kondukteru
     *
     * @param sc scanner za unos podataka
     * @return objekt konduktera
     */
    private static Conductor ucitajKonduktere(Scanner sc) {
        log.info("Ucitaj konduktere metoda je pokrenuta.");
        String name;
        String surname;
        Integer age;
        System.out.println("Unesite ime konduktera:");
        name=sc.nextLine();
        System.out.println("Unesite prezime konduktera:");
        surname=sc.nextLine();
        System.out.println("Unesite godine konduktera:");
        age=sc.nextInt();
        sc.nextLine();
        Conductor kondukter=new Conductor(name,surname,age);
        System.out.println("Unesite username konduktera:");
        kondukter.setUsername(sc.nextLine());
        System.out.println("Unesite password konduktera:");
        kondukter.setPassword(sc.nextLine());
        System.out.println("Unesite broj dodijeljenih vozila kondukteru:");
        kondukter.setNumberOfAssignedVehicles(sc.nextInt());
        sc.nextLine();
        System.out.println();
        log.info("Ucitaj konduktere metoda je zavrsena.");
        return kondukter;
    }
    /**
     * upisuje putnike
     *
     * upisuje ime, prezime, godine te jedinstveni broj karte putnika
     *
     * @param sc scanner za unos podataka
     * @return objekt putnika
     */
    private static Passenger upisiPutnike(Scanner sc){
        String name;
        String surname;
        String ticketNumber;
        Integer age;
        System.out.println("Unesite ime putnika:");
        name=sc.nextLine();
        System.out.println("Unesite prezime putnika:");
        surname=sc.nextLine();
        System.out.println("Unesite godine putnika:");
        age=sc.nextInt();
        sc.nextLine();
        System.out.println("Unesite jedinstveni broj karte putnika:");
        ticketNumber=sc.nextLine();
        System.out.println();
        return new Passenger(name,surname,age,ticketNumber);
    }
    /**
     * učitava vozila
     *
     * upisuje registraciju, tip, kapacitet vozila te dodjeljuje vozace vozilu
     *
     * @param sc scanner za unos podataka
     * @param vozaci vozaci koji se mogu dodijeliti vozilu
     * @return objekt vozila
     */
    private static Vehicle ucitajVozila(Scanner sc,Set<Driver> vozaci) {
        log.warn("Niz vozaca bi mogao biti prazan ako prethodno nije unesen niti jedan vozac.");
        Integer ponovno = 0;
        String zapisano;
        String prov;
        String trazi = "DA";
        Map<String, Driver> mapaVozaca=new HashMap<>();
        for (Driver driver : vozaci) {
            mapaVozaca.put(driver.getUsername(), driver);
        }
        Vehicle vozilo=new Vehicle();
        System.out.println("Upisi registraciju vozila:");
        vozilo.setRegistrationNumber(sc.nextLine());
        System.out.println("Upisi tip vozila:");
        vozilo.setType(sc.nextLine());
        System.out.println("Upisi kapacitet vozila:");
        vozilo.setCapacity(sc.nextInt());
        sc.nextLine();

        System.out.println("Upisi 1 za spremanje svih vozaca trenutnom vozilu koji su prethodno upisani" + "\n" +
                "2 za odabir između prethodno upisanih vozaca:");
        zapisano = sc.nextLine();

        switch (zapisano) {
            case "1" -> vozilo.setDrivers(vozaci);
            case "2" -> {
                log.debug("Odabir vozaca za vozilo je pokrenut.");

                System.out.println("Upisi username vozaca kojeg zelis dodati: ");
                prov = sc.nextLine();
                while (trazi.equals("DA")) {
                    if(mapaVozaca.get(prov)!=null){
                        ponovno=1;
                        vozilo.addDriver(mapaVozaca.get(prov));
                    }
                    if (ponovno == 0) {
                        System.out.println("Ovaj username se ne nalazi u bazi podataka. Upisi DA ako zelis ponovo traziti ili" +
                                "NE za prekidanje pretraživanja:");
                        trazi = sc.nextLine();
                    }
                    else{
                        System.out.println("Upisi DA ako zelis ponovo traziti ili NE za prekidanje pretraživanja:");
                        trazi = sc.nextLine();
                    }
                    log.debug("Odabir vozaca za vozilo je zavrsen.");
                }
            }
            default-> System.out.println("Pogresan unos.");
        }
        return vozilo;
    }
    /**
     * učitava rute
     * <p>
     *
     * upisuje početnu i završnu stanicu rute, broj stanica te vozila dodijeljena ruti
     *
     * @param sc scanner za unos podataka
     * @param vozila vozila dodijeljena ruti
     * @return objekt rute
     */
    private static Route ucitajRute(Scanner sc,Set<Vehicle> vozila){
        log.warn("Niz vozila bi mogao biti prazan ako prethodno nije uneseno niti jedno vozilo.");
        Integer ponovo = 0;
        String zapis;
        String provjera;
        String trazi = "DA";
        Route ruta = new Route();
        System.out.println("Upisi naziv pocetne stanice rute:");
        ruta.setStartStation(sc.nextLine());
        System.out.println("Upisi naziv zadnje stanice rute:");
        ruta.setEndStation(sc.nextLine());
        System.out.println("Upisi sveukupan broj stanica rute:");
        ruta.setNumberOfStops(sc.nextInt());
        sc.nextLine();
        System.out.println("Upisi 1 za spremanje svih vozila na trenutnu rutu koja su prethodno upisana" + "\n" +
                "2 za odabir između prethodno upisanih vozila:");
        zapis = sc.nextLine();
        switch (zapis) {

            case "1" -> ruta.setVehicles(vozila);
            case "2" -> {
                System.out.println("Upisi registraciju vozila koje zelis dodati: ");
                provjera = sc.nextLine();
                while (trazi.equals("DA")) {
                    for (Vehicle v : vozila) {
                        if (provjera.equals(v.getRegistrationNumber())) {
                            ponovo = 1;
                            ruta.addVehicle(v);
                            break;
                        }
                    }
                    if (ponovo == 0) {
                        System.out.println("Ova registracija se ne nalazi u bazi podataka. Upisi DA ako zelis ponovo traziti ili" +
                                "NE za prekidanje pretraživanja:");
                        trazi = sc.nextLine();
                    } else {
                        System.out.println("Upisi DA ako zelis ponovo traziti ili NE za prekidanje pretraživanja:");
                        trazi = sc.nextLine();
                    }
                }
            }
            default-> System.out.println("Pogresan unos.");
        }
        return ruta;
    }
    /**
     * ispisuje informacije o vozacima na određenoj ruti
     *
     * @param provjera indikator za pokretanje pretrage
     * @param sc scanner za unos podataka
     * @param rute rute među kojima se pretražuje
     */
    private static void InfoVozac(Integer provjera,Scanner sc,List<Route> rute){
        while(provjera==1){
            Integer trazenje=-1;
            String poc;
            String kraj;
            System.out.println("Upisi pocetnu  stanicu rute:");
            poc=sc.nextLine();
            System.out.println("Upisi krajnju stanicu rute:");
            kraj=sc.nextLine();
            List<Driver> vozaci=rute.stream().filter(s-> s.getStartStation().equals(poc)
                            && s.getEndStation().equals(kraj))
                                .flatMap(r-> r.getVehicles().stream())
                                .flatMap(v-> v.getDrivers().stream())
                                .sorted(Comparator.comparingInt(Driver::getAge))
                                .toList();
            if(!vozaci.isEmpty()){
                vozaci.forEach(System.out::println);
                trazenje=0;
            }
            if(trazenje==-1){
                System.out.println("Ove rute nema u bazi podataka. Upisi 1 ako zelis traziti za drugu rutu ili 0 ako zelis prekinuti:");
                provjera=sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Upisi 1 ako zelis ponovo traziti za drugu rutu ili 0 ako zelis prekinuti:");
                provjera=sc.nextInt();
                sc.nextLine();
            }
        }
    }
    private static void ispisljudi(List<? extends Person> lista){
        for (Person t : lista) {
            System.out.println(t.getName()+" "+t.getSurname()+" "+t.getAge());
            System.out.println("\n");
        }
    }
    /**
     * pronalazi najkraću rutu
     *
     * @param rute rute među kojima se traži najkraća
     * @return najkraća ruta
     */
    private static Optional<Route> najkracaRuta(List<Route> rute){
        Optional<Route> najkraca=rute.stream()
                .min(Comparator.comparingInt(Route::getNumberOfStops));
        return najkraca;
    }
    /**
     * pronalazi vozilo sa najmanjim kapacitetom
     *
     * @param vozila vozila među kojima se traži
     * @return vozilo sa najmanjim kapacitetom
     */
    private static Optional<Vehicle> najmKapacitet(Set<Vehicle> vozila){
        Optional<Vehicle> najm=vozila.stream()
                .min(Comparator.comparingInt(Vehicle::getCapacity));
        return najm;
    }
    /**
     * pronalazi najmlađeg vozača
     *
     * @param trazi niz osoba među kojima se traži najmlađi vozač
     */
    private static void najmladi(List<Person> trazi){
        log.warn("Niz osoba bi mogao biti prazan ako prethodno nije unesen niti jedan vozac ili kondukter.");
        Optional<Driver> najml=trazi.stream()
                .filter(d-> d instanceof Driver)
                .map(d->(Driver) d)
                .min(Comparator.comparingInt(Driver::getAge));

        najml.ifPresent(driver -> System.out.println("Najmladi vozac je " + driver.getName() + " " + driver.getSurname() + " sa " + driver.getAge() + " godina."));

    }
}
