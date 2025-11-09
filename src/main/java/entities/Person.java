package entities;

/**
 * Abstraktna klasa koja predstavlja osobu sa osnovnim atributima.
 * Sadrži atribute ime, prezime i godine, kao i njihove gettere i settere.
 * @author Mihael Filić
 * @version 1.0
 * @since Java 25
 */
public abstract class Person {
    private String name;
    private String surname;
    private Integer age;

    /**
     * kreira osobe sa zadanim imenom, prezimenom i godinama.
     * @param name Ime osobe.
     * @param surname Prezime osobe.
     * @param age Godine osobe.
     */
    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    /**
     * Vraća ime osobe.
     * @return ime osobe.
     */
    public String getName() {
        return name;
    }
    /**
     * Postavlja ime osobe.
     * @param name novo ime osobe.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Vraća prezime osobe.
     * @return prezime osobe.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Postavlja prezime osobe.
     * @param surname novo prezime osobe.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Vraća godine osobe.
     * @return godine osobe.
     */
    public Integer getAge() {
        return age;
    }
    /**
     * Postavlja godine osobe.
     * @param age nove godine osobe.
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
