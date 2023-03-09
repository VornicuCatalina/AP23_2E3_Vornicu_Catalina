package LAB2.Bonus;

import java.util.ArrayList;

public class Solution {
    private double[][] matrixLength;
    private double[][] matrixFastest;
    private ArrayList<String> sol;
    private boolean value=true;
    public void setSol(ArrayList<String> p,int len){
        sol=new ArrayList<>(len);
        sol.addAll(p);
    }
    public void setMatrices(int len){
        matrixLength=new double[len][len];
        matrixFastest=new double[len][len];
    }
    public void setMatrixLength(int idxR,int idxC,double length){
        matrixLength[idxR][idxC]=length;
    }
    public void setMatrixFastest(int idxR,int idxC,double speed){
        matrixFastest[idxR][idxC]=speed;
    }
    public void setValue(boolean x){
        this.value=x;
    }
    public void MinLength(Location i,Location j,Problem p) {
        if (!(p.checkerLocation(i)) && !(p.checkerLocation(j))) {
            StringBuilder sd = new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            if (matrixLength[sol.indexOf(i.getNameLocation())][sol.indexOf(j.getNameLocation())] == 0.0) {
                sd.append(" DOES NOT EXIST!");
            } else {
                sd.append(" HAS THE MINIMUM LENGTH: ");
                sd.append(matrixLength[sol.indexOf(i.getNameLocation())][sol.indexOf(j.getNameLocation())]);
            }
            System.out.println(sd);
        } else {
            System.err.println("INVALID CALL OF LOCATIONS");
        }
    }
    public void ShortestTime(Location i,Location j,Problem p) {
        if (!(p.checkerLocation(i)) && !(p.checkerLocation(j))) {
            StringBuilder sd = new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            if (matrixFastest[sol.indexOf(i.getNameLocation())][sol.indexOf(j.getNameLocation())] == 0.0) {
                sd.append(" DOES NOT EXIST!");
            } else {
                sd.append(" HAS THE SHORTEST TIME: ");
                sd.append(matrixFastest[sol.indexOf(i.getNameLocation())][sol.indexOf(j.getNameLocation())]);
            }
            System.out.println(sd);
        } else {
            System.err.println("INVALID CALL OF LOCATIONS");
        }
    }
    @Override
    public String toString(){
        if(value==false){
            return "There are some locations that are not connected\n";
        }
        return "ALL locations are connected\n";
    }
}
