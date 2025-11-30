package entities.Services;

import org.slf4j.Logger;

import java.io.*;
import java.util.Collections;
import java.util.Set;

public class BinService {

    private final Logger log;

    public BinService(Logger log) {
        this.log = log;
    }

    public void saveToBin(Set<?> data, String filePath) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();

        }
    }
    public <T> Set<T> loadFromBin(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Set<?>) {
                return (Set<T>) obj;
            } else {
                System.out.println("Datoteka ne sadrži Set.");
                return Collections.emptySet();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
    }


}
