package bonus.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import bonus.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {

    public SaveCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public void saveBinary(Catalog catalog, String path) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(catalog);
        }
    }
}
