package LAB2.Bonus;

public class GasStation extends Location {
    private int price;
    public GasStation(String name, int price, int k1, int k2){
        this.x=k1;
        this.y=k2;
        this.nameLocation=name;
        this.location="gas station";
        this.price=price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
}
