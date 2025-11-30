package entities.AppClasses;

import java.io.Serializable;

/**
 * Predstavlja putnika u sistemu javnog prevoza.
 *
 * Sadrzi osnovne informacije o putniku kao sto su ime, prezime, godine i broj karte.
 *
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public record Passenger (
    String name,
    String surname,
    Integer age,
    String ticketNumber
) implements Serializable {
}
