package compulsory.factories;

public class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("DAO")) {
            return new DAOFactory();
        } else if (choice.equalsIgnoreCase("Entity")) {
            return new EntitiesFactory();
        }
        return null;
    }
}
