package entities;

/**
 * Sučelje BusDriver definira metode koje mora implementirati svaki vozač autobusa.
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public interface BusDriver {
    String vozacBus="vozac busa";
    /**
     * Metoda za upravljanje autobusom.
     */
    void driveBus();

    /**
     * Metoda za parkiranje autobusa.
     */
    void parkBus();
}
