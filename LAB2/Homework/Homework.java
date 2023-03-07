package LAB2.Homework;


import LAB2.Compulsory.RoadType;

public class Homework {
    public static void main(String[] args) {
        Problem p=new Problem(2,3);
        Location l1=new City("heyo", 123000,23,24);
        Location l3=new Airport("nao",122,12,42);
        p.setLocations(l1);
        p.setLocations(l3);
        //p.getLocations();
        Road r1=new Road(RoadType.COUNTRY,68.3,12,l1,l3);
        p.setRoads(r1);
    }
}
