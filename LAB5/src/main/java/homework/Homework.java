package homework;

import freemarker.template.TemplateException;
import homework.commands.*;

import java.io.IOException;

public class Homework {
    public static void main(String[] args) throws InvalidCatalogException, IOException, InvalidDocName, TemplateException, InvalidCatalog {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("book1", "article", "C:/Users/User/Documents/Advanced Programming/book.txt", "123as");
        var article = new Document("article1", "article", "C:/Users/User/Documents/Advanced Programming/article.txt", "das24");

        Command command = new AddCommand(catalog);
        command.viewCommands();
        command.add(book);
        command.add(article);

        command = new ToString(catalog);
        System.out.println(command.toString());

        command = new SaveCommand(catalog);
        command.save(catalog, "C:/Users/User/Documents/Advanced Programming/catalog2.json");

        command = new LoadCommand();
        Catalog catalog1 = command.load("C:/Users/User/Documents/Advanced Programming/catalog2.json");

        command = new ToString(catalog1);
        System.out.println(command.toString());

        command = new ListCommand(catalog);
        command.showList();

        command = new ViewCommand(catalog);
        command.viewCatalog(catalog.getDocs().get(0));

        command = new ReportCommand(catalog);
        command.reportHTML();
    }
}
