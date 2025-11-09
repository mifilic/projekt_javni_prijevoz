package entities;

public enum Konstante {
    POLJA(2);
    private final double vrijednost;

    Konstante(Integer vrijednost) {
        this.vrijednost = vrijednost;
    }
    public double getValue() {
        return vrijednost;
    }
}
