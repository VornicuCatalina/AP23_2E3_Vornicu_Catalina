package bonus;

import bonus.commands.AddCommand;
import bonus.commands.Command;
import bonus.commands.ReportCommand;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Bonus {
    public static void main(String[] args) throws TikaException, IOException, SAXException, TemplateException, InvalidCatalog {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("book1", "article", "C:/Users/User/Documents/Advanced Programming/bookMaster.txt", "123as");
        var article = new Document("article1", "article", "C:/Users/User/Documents/Advanced Programming/article.txt", "das24");
        book.addTag("code","book");
        article.addTag("yes","book");
        Command command = new AddCommand(catalog);
        command.add(book);
        command.add(article);
        article = new Document("article2", "article", "C:/Users/User/Documents/Advanced Programming/article2.txt", "da4");
        article.addTag("key","article");
        command.add(article);
        article = new Document("article3", "article", "C:/Users/User/Documents/Advanced Programming/article3.txt", "d4");
        article.addTag("keys","smth");
        command.add(article);

        catalog.info();
        System.out.println("\n\n");
        catalog.ColorAlg();
    }
}
