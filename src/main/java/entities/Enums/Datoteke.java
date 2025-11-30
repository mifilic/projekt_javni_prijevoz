package entities.Enums;
public enum Datoteke {
    KONDUKTERI("./AppData/kondukteri.json"),
    VOZACI("./AppData/vozaci.json"),
    VOZILA("./AppData/vozila.json"),
    RUTE("./AppData/rute.json"),
    PUTNICI("./AppData/putnici.json"),
    KONDUKTERI_BACKUP("./backupAppData/kondukteri_backup.bin"),
    VOZACI_BACKUP("./backupAppData/vozaci_backup.bin"),
    VOZILA_BACKUP("./backupAppData/vozila_backup.bin"),
    RUTE_BACKUP("./backupAppData/rute_backup.bin"),
    PUTNICI_BACKUP("./backupAppData/putnici_backup.bin");
    private final String putanja;
    Datoteke(String putanja) {
        this.putanja = putanja;
    }
    public String getPutanja() {
        return putanja;
    }
}
