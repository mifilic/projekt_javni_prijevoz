package entities.Services;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import org.slf4j.Logger;
import entities.AppClasses.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonService {

    private final Logger log;

    public JsonService(Logger log) {
        this.log = log;
    }

    public void saveToJson(Set<?> data, String filePath) {
        try {
            JsonbConfig config = new JsonbConfig().withFormatting(true);
            Jsonb jsonb = JsonbBuilder.create(config);
            String jsonString = jsonb.toJson(data);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(jsonString);
            } catch (IOException ioe) {
                log.error(ioe.getMessage(), ioe);
                System.err.println("Error writing to file: " + ioe);
                ioe.printStackTrace();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
    public <T> Set<T> loadFromJson(String filePath) {
        Set<T> data = new LinkedHashSet<>();
        try {
            Jsonb jsonb = JsonbBuilder.create();
            String jsonString = Files.readString(Paths.get(filePath));
            Type setType = new LinkedHashSet<T>() {}.getClass().getGenericSuperclass();
            Set<T> loadedData = jsonb.fromJson(jsonString, setType);
            data.addAll(loadedData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return data;
    }
}

//System.out.println("Zelis li spremiti podatke u pricuvnu datoteku? (da/ne)");
//Scanner sc = new Scanner(System.in);
//String odgovor = sc.nextLine();
//        if (odgovor.equalsIgnoreCase("da")) {
