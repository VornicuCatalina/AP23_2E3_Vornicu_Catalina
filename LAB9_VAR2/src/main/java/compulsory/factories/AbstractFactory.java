package compulsory.factories;

public abstract class AbstractFactory {
    public abstract DAOClasses create(String type);

    public abstract EntitiesClasses createEn(String type);
}
