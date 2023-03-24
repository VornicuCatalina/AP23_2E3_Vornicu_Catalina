package compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog(String catalog) {
        this.name = catalog;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }
}
