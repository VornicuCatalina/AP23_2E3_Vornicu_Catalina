package LAB2.Homework;

public class Airport extends Location {
    private int noTerminals;
    public Airport(String name,int no,int k1,int k2){
        this.x=k1;
        this.y=k2;
        this.nameLocation=name;
        this.location="airport";
        this.noTerminals=no;
    }
    public void setNoTerminals(int no){
        this.noTerminals=no;
    }
    public int getNoTerminals(){
        return noTerminals;
    }
}
