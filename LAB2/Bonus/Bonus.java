package LAB2.Bonus;


public class Bonus {
    public static void main(String[] args) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore =
                runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        Problem p=new Problem(6,5);
        Location l1=new City("heyo", 123000,23,24);
        Location l3=new Airport("nao",122,12,42);
        Location l2=new GasStation("hmm",12,12,32);
        Location l4=new GasStation("smth",133,12,33);
        p.setLocations(l2);
        p.setLocations(l4);
        p.setLocations(l1);
        p.setLocations(l3);
        Road r1=new Road("banana", RoadType.COUNTRY,68.3,12,l1,l3);
        Road r2=new Road("chiciu", RoadType.EXPRESS,80,120,l2,l4);
        Road r3=new Road("hmmmmmm", RoadType.EXPRESS,120,180,l1,l2);
        Road r4=new Road("yes",RoadType.EXPRESS,120,234,l2,l3);
        p.setRoads(r1);
        p.setRoads(r2);
        p.setRoads(r3);
        p.setRoads(r4);
        Algorithm a=new DijkstraAlgorithm(p);
        Solution sol=a.solve();
        System.out.println(sol);
        sol.MinLength(l1,l2,p);
        sol.ShortestTime(l2,l3,p);
        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println(" usedMemory "+runningTime+"\n memoryIncrease "+memoryIncrease);
    }
}
