package LAB2.Homework;


import LAB2.Compulsory.RoadType;

public class Homework {
    public static void main(String[] args) {
        Problem p=new Problem(4,3);
        Location l1=new City("heyo", 123000,23,24);
        Location l3=new Airport("nao",122,12,42);
        Location l2=new GasStation("hmm",12,12,32);
        Location l4=new GasStation("smth",133,12,32);
        p.setLocations(l2);
        p.setLocations(l4);
        p.setLocations(l1);
        p.setLocations(l3);
        Road r1=new Road("banana",RoadType.COUNTRY,68.3,12,l1,l3);
        Road r2=new Road("chiciu",RoadType.EXPRESS,80,120,l2,l4);
        Road r3=new Road("hmmmmmm",RoadType.EXPRESS,120,180,l1,l2);
        p.setRoads(r1);
        p.setRoads(r2);
        p.setRoads(r3);
        Algorithm alg=new Algorithm(p);
        alg.existenceOfRoute(l1,l3,p);
        alg.existenceOfRoute(l2,l4,p);
        alg.existenceOfRoute(l1,l4,p);
        /**
         * Just checking this thing out
         */
    }
}
