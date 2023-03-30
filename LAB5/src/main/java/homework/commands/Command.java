package homework.commands;

import homework.Catalog;
import homework.Document;
import homework.InvalidCatalogException;
import homework.InvalidDocName;

import java.io.IOException;

public abstract class Command {
    Catalog catalog;
    public void viewCommands(){
        System.out.println("You can use the following commands:\n" +
                "1. add -> adding a document in the catalog\n" +
                "2. list -> showing all the documents that you've got so far\n" +
                "3. load -> loading the document\n" +
                "4. save -> saving the document in a json file\n" +
                "5. report -> a html report\n" +
                "6. view -> opening document");
    }

    //for AddCommand
    public void add(Document doc){};

    //for ListCommand
    public void showList(){};

    //for SaveCommand
    public void save(Catalog catalog, String path) throws IOException {};
    public void saveBinary(Catalog catalog, String path) throws IOException {};

    //for LoadCommand
    public Catalog load(String path) throws InvalidCatalogException, IOException { return new Catalog();};
    public Catalog loadBinary(String path) throws InvalidCatalogException, IOException { return new Catalog();}

    //for ViewCommand
    public void viewCatalog(Document document) throws IOException, InvalidDocName {};

    //for ReportCommand
    public void reportHTML(){};

}
