package bonus.commands;

import bonus.*;

import java.util.LinkedList;

public class AddCommand extends Command {
    public AddCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void add(Document doc) {
        catalog.getDocs().add(doc);
        catalog.addingVertex(doc);
        for(String tag:doc.getTags().values()) {
            if (catalog.getTags().contains(tag)){
                catalog.modifyValue(tag);
            }
            else{
                catalog.addValue(tag,doc);
                catalog.getTags().add(tag);
            }
            catalog.addingEdges(doc,tag);
        }
    }
}
