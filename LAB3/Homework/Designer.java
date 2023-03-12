package LAB3.Homework;

import java.time.LocalDate;

public class Designer extends Person {
    private int noCollections=0;
    public Designer(String name,int year,int month,int day){
        this.name=name;
        this.specialisation="programmer";
        date=LocalDate.of(year,month,day);
    }

    public void setNoCollections(int noCollections) {
        this.noCollections = noCollections;
    }

    public int getNoCollections() {
        return noCollections;
    }
}
