package LAB2.Homework;

public abstract class Location {
    protected String nameLocation;
    protected String location;
    protected int x;
    protected int y;
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
    public void setLocation(String n){
        this.location=n;
    }
    public String getLocation(){
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
        return "The location has: the name " + this.getNameLocation()+ " , type "+this.getLocation()+" , coordinate X "+this.getX()+" and Y "+this.getY()+"\n";
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
