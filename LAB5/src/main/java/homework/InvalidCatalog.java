package homework;

public class InvalidCatalog extends Exception {
    public InvalidCatalog(Exception e) {
        System.out.println(e);
    }
}