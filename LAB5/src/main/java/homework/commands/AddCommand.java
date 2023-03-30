package homework.commands;

import homework.Catalog;
import homework.Document;

public class AddCommand extends Command {
    public AddCommand(Catalog catalog){
        this.catalog=catalog;
    }
    @Override
    public void add(Document doc) {
        catalog.getDocs().add(doc);
    }
}
