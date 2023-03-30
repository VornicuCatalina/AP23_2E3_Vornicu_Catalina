package homework.commands;

import homework.Catalog;
import homework.Document;
import homework.InvalidDocName;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{
    public ViewCommand(Catalog catalog){
        this.catalog=catalog;
    }

    public void viewCatalog(Document document) throws IOException, InvalidDocName {
        if(!catalog.getDocs().contains(document)){
            throw new InvalidDocName("not part of the catalog");
        }
        else {
            Desktop helper = Desktop.getDesktop();
            File fileDocument = new File(document.getLocation());
            fileDocument.createNewFile();
            System.out.println(fileDocument);
            if (fileDocument.exists()) {
                helper.open(fileDocument);
            } else {
                System.out.println("It does not exist");
            }
        }
    }
}
