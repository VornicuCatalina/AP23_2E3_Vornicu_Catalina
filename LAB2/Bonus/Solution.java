package LAB2.Bonus;

import java.util.ArrayList;

public class Solution {
    private double[][] matrixLength; //the matrix that stores the length between 2 locations, the shortest path
    private double[][] matrixFastest; //the matrix that stores the taken time to reach a location from another, the shortest amount of time
    private ArrayList<String> sol; //the array that we will use to access the indexes so that we can build the matrices without any complications
    private boolean value=true; //checker if all locations are connected or not
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
        if (!(p.checkerLocation(i)) && !(p.checkerLocation(j))) { //if the locations exist
            StringBuilder sd = new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            int row=sol.indexOf(i.getNameLocation());
            int column=sol.indexOf(j.getNameLocation());
            if (matrixLength[row][column] == 0.0) {//checking the value in the matrix
                sd.append(" DOES NOT EXIST!");
            } else {
                sd.append(" HAS THE MINIMUM LENGTH (IN KM) : ");
                sd.append(matrixLength[row][column]);
            }
            System.out.println(sd);
        } else {
            System.err.println("INVALID CALL OF LOCATIONS");
        }
    }
    public void ShortestTime(Location i,Location j,Problem p) {
        if (!(p.checkerLocation(i)) && !(p.checkerLocation(j))) { //if the locations exist
            StringBuilder sd = new StringBuilder("The route from ");
            sd.append(i.getNameLocation());
            sd.append(" to ");
            sd.append(j.getNameLocation());
            int row=sol.indexOf(i.getNameLocation());
            int column=sol.indexOf(j.getNameLocation());
            if (matrixFastest[row][column] <= 0.0) { //checking the value in the matrix
                sd.append(" DOES NOT EXIST!");
            } else {
                sd.append(" HAS THE SHORTEST TIME (IN HOURS): ");
                sd.append(matrixFastest[row][column]);
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
