package homework;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs;

    public Catalog(String catalog) {
        docs = new ArrayList<>();
        this.name = catalog;
    }

    public Catalog() {
        docs = new ArrayList<>();
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }
}
