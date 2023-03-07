package LAB2.Compulsory;

public class Location {
    LocationType location;
    private String nameLocation;
    private int x;
    private int y;
    public Location(String loc,int k1,int k2){
        this.nameLocation=loc;
        this.x=k1;
        this.y=k2;
        this.location=LocationType.CITY;
    }
    public Location(LocationType loc,String n,int k1,int k2){
        this.location=loc;
        this.x=k1;
        this.y=k2;
        this.nameLocation=n;
    }
    public Location(){
        this.nameLocation="Home";
        this.x=0;
        this.y=0;
        this.location=LocationType.CITY;
    }
    public void setX(int k1){
        this.x=k1;
    }
    public int getX(){
        return x;
    }
    public void setY(int k2){
        this.y=k2;
    }
    public int getY(){
        return y;
    }
    public void setName(LocationType n){
        this.location=n;
    }
    public LocationType getName(){
        return location;
    }
    public void setNameLocation(String loc){
        this.nameLocation=loc;
    }
    public String getNameLocation(){
        return nameLocation;
    }
    @Override
    public String toString(){
        return "The location has: the name " + this.getNameLocation()+ " , type "+this.getName()+" , coordinate X "+this.getX()+" and Y "+this.getY()+"\n";
    }
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if(!(o instanceof Location)){
            return false;
        }
        Location l=(Location) o;
        return l.getNameLocation().equals(nameLocation);
    }
}
