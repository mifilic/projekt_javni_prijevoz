package entities.Enums;

public enum Konstante {
    POLJA(5),
    VOZACI(1),
    KONDUKTERI(2),
    VOZILA(3),
    RUTE(4),
    PUTNICI(5);
    private final double vrijednost;
    Konstante(Integer vrijednost) {
        this.vrijednost = vrijednost;
    }
    public double getValue() {
        return vrijednost;
    }
}
