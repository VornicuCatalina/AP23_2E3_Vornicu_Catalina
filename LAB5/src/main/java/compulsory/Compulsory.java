package compulsory;

import java.io.IOException;

public class Compulsory {
    public static void main(String[] args) throws InvalidCatalogException, IOException {
        Compulsory app = new Compulsory();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("123as", "article", "C:/Users/User/Documents/Advanced Programming/book.txt", "123as");
        var article = new Document("das24", "article", "C:/Users/User/Documents/Advanced Programming/article.txt", "das24");
        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog, "C:/Users/User/Documents/Advanced Programming/catalog2.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:/Users/User/Documents/Advanced Programming/catalog2.json");
        System.out.println(catalog.toString());
    }
}