package compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static void saveBinary(Catalog catalog, String path) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(path))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog loadBinary(String path) throws InvalidCatalogException, IOException {
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
