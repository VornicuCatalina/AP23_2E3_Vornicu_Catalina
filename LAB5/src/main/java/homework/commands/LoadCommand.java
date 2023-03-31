package homework.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.Catalog;
import homework.InvalidCatalogException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command {
    public Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public Catalog loadBinary(String path) throws InvalidCatalogException, IOException {
        Catalog catalog;
        try (var oos = new ObjectInputStream(
                new FileInputStream(path))) {
            catalog = (Catalog) oos.readObject();
        } catch (ClassNotFoundException e) {
            throw new InvalidCatalogException(e);
        }
        return catalog;
    }
}
