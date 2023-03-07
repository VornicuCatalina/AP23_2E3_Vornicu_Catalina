package LAB2.Homework;



public class Problem {
    private Location[] locations;
    private Road[] roads;
    private int noLocation=0;
    private int nrloc=0;
    private int noRoads=0;
    private int nrroad=0;
    public Problem(int nrloc,int nrroad){
        this.nrloc=nrloc;
        this.nrroad=nrroad;
        locations=new Location[nrloc];
        roads=new Road[nrroad];
    }
    public void setLocations(Location l){
        if(this.noLocation<this.nrloc){
            if(checkerLocation(l)){
                this.locations[noLocation]=l;
                noLocation++;
            }
            else{
                System.err.println("ALREADY HAVE THIS LOCATION: "+l.getNameLocation());
            }
        }
        else{
            System.err.println("THE CAPACITY GOT REACHED AT NUMBER OF LOCATIONS");
        }
    }
    public void getLocations(){
        for(int i=0;i<noLocation;i++){
            System.out.println(locations[i]);
        }
    }
    public void setRoads(Road roads) {
        if(checker(roads.getA().getNameLocation())&&checker(roads.getB().getNameLocation())){
            if(roads.getA().equals(roads.getB())){
                System.err.println("YOU MUST SPECIFY 2 DIFFERENT LOCATIONS");
            }
            else{
                if(coordinates(roads.getA().getX(),roads.getB().getX(),roads.getA().getY(),roads.getB().getY(),roads.getLength())){
                    if(noRoads<nrroad){
                        if(checkerRoad(roads)){
                            this.roads[noRoads]=roads;
                            noRoads++;
                        }
                    }
                    else{
                        System.err.println("THE CAPACITY GOT REACHED AT NUMBER OF ROADS");
                    }
                }
                else{
                    System.err.println("THE LENGTH IS INVALID");
                }

            }
        }
        else{
            System.err.println("THE NAME OF LOCATIONS HAVE NOT BEEN DECLARED");
        }
    }
    public void getRoads(){
        for(int i=0;i<noRoads;i++){
            System.out.println(roads[i]);
        }
    }
    public boolean checker(String n){
        for(int i=0;i<noLocation;i++){
            if(n.equals(locations[i].getNameLocation())){
                return true;
            }
        }
        return false;
    }
    public boolean coordinates(int cordX1,int cordY1, int cordX2, int cordY2, double distance){
        double d=Math.sqrt(Math.pow(cordX2-cordX1,2)+Math.pow(cordY2-cordY1,2));
        System.out.println("d is "+d+" and dist is "+distance);
        if(d<=distance){
            return true;
        }
        return false;
    }
    public boolean checkerLocation(Location loc) {
        for (int i = 0; i < noLocation; i++) {
            if (loc.equals(locations[i])) {
                return false;
            }
        }
        return true;
    }
    public boolean checkerRoad(Road road) {
        for (int i = 0; i < noRoads; i++) {
            if (road.equals(roads[i])) {
                return false;
            }
        }
        return true;
    }
}
