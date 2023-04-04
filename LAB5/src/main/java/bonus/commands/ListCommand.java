package bonus.commands;

import bonus.*;

public class ListCommand extends Command {
    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void showList() {
        System.out.print("The documents are: ");
        for (Document doc : catalog.getDocs()) {
            System.out.print(doc.getTitle() + " , ");
        }
        System.out.println();
    }
}
