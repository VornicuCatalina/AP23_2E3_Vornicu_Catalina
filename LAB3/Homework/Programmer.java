package LAB3.Homework;

import java.time.LocalDate;

public class Programmer extends Person {
    private int knownCodingLanguages;
    public Programmer(String name,int year,int month,int day){
        this.name=name;
        this.specialisation="programmer";
        date=LocalDate.of(year,month,day);
    }

    public void setKnownCodingLanguages(int knownCodingLanguages) {
        this.knownCodingLanguages = knownCodingLanguages;
    }

    public int getKnownCodingLanguages() {
        return knownCodingLanguages;
    }
}
