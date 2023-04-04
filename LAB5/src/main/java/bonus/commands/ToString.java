package bonus.commands;

import bonus.*;

public class ToString extends Command {
    public ToString(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + catalog.getName() + '\'' +
                ", docs=" + catalog.getDocs() +
                '}';
    }
}
