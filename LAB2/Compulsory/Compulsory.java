package LAB2.Compulsory;

public class Compulsory {
    public static void main(String[] args){
        RoadType rt1=RoadType.HIGHWAYS;
        LocationType lt1=LocationType.AIRPORT;
        Location l1=new Location(lt1,"Mamaia",23,35);
        Location l2=new Location();
        Location l3=new Location("hm",234,23);
        Road r1=new Road(12.3,120);
        Road r2=new Road();
        Road r3=new Road(rt1,23.4,12);
        System.out.println("l1 is "+l1.getX());
        l1.setNameLocation("hm2");
        l2.setX(23);
        l2.setY(34);
        System.out.println("r1 is "+r1.getLength());
        r2.setLength(34);
        r2.setSpeed(124);
        System.out.println("l2 is "+l2.getY());
        System.out.println("r2 is "+r2.getSpeed());
        System.out.println("r3 is "+r3.getName());
        System.out.println("l3 is "+l3.getName());
        System.out.println(r2.toString());
        System.out.println(l1.toString());
    }
}
