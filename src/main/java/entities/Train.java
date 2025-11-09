package entities;
/**
 * Predstavlja sučelje za vlakove u sistemu javnog prijevoza.
 *
 * Sadrzi metode za upravljanje vlakom kao sto su ukljucivanje, iskljucivanje,
 * dodavanje i uklanjanje vagona.
 *
 *
 *
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */

public sealed interface Train permits Vehicle {
    String ime="Vlak";

    /**
     * Uključuje vlak.
     */
    void ukljuciVlak();
    /**
     * Isključuje vlak.
     */
    void iskljuciVlak();
    /**
     * Dodaje vagon vlaku.
     */
    void dodajVagon();
    /**
     * Uklanja vagon iz vlaka.
     */
    void ukloniVagon();
}
