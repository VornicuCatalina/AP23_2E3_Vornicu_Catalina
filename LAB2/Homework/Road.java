package LAB2.Homework;

import LAB2.Compulsory.RoadType;

public class Road {
    RoadType type;
    private String name;
    private double length;
    private int speed;
    private Location a;
    private Location b;
    public Road(String name,RoadType n, double l, int s,Location a, Location b){
        this.name=name;
        this.length=l;
        this.speed=s;
        this.type=n;
        this.a=a;
        this.b=b;
    }
    public void setLength(double l){
        this.length=l;
    }
    public double getLength(){
        return length;
    }
    public void setSpeed(int s){
        this.speed=s;
    }
    public int getSpeed(){
        return speed;
    }
    public void setName(String n){
        this.name=n;
    }
    public String getName(){
        return name;
    }
    public void setType(RoadType n){
        this.type=n;
    }
    public RoadType getType(){
        return type;
    }
    public Location getA(){
        return a;
    }
    public Location getB(){
        return b;
    }
    @Override
    public String toString(){
        return "The road has: name " +this.getName()+" , type "+this.getType()+" , speed "+this.getSpeed()+" and length "+this.getLength()+"\n";
    }
    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if(!(o instanceof Road)){
            return false;
        }
        Road l=(Road) o;
        return l.getName().equals(name);
    }
}
