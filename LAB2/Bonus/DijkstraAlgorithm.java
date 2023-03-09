package LAB2.Bonus;

import java.util.ArrayList;

public class DijkstraAlgorithm extends Algorithm {
    //for implementing the subclass of algorithm
    public DijkstraAlgorithm(Problem p){
        s=new Solution(); //creating the solution object
        help=new ArrayList<>(p.getNoLocation());
        for(int j=0;j<p.getNoLocation();j++){
            help.add(p.getLocations(j).getNameLocation());
        }
        s.setSol(help, p.getNoLocation()); //adding the locations in a <string> arraylist
        matrix=new int[p.getNoLocation()][p.getNoLocation()];
        //new
        s.setMatrices(p.getNoLocation()); //initializing the matrices in Solution
        matrixLength=new double[p.getNoLocation()][p.getNoLocation()];
        matrixFast=new double[p.getNoLocation()][p.getNoLocation()];
        for(int j=0;j<p.getNoLocation();j++){
            matrixLength[j][j]=Double.POSITIVE_INFINITY;
            matrixFast[j][j]=Double.POSITIVE_INFINITY;
            for(int k=j+1;k<p.getNoLocation();k++){
                matrixLength[j][k]=Double.POSITIVE_INFINITY;
                matrixLength[k][j]=Double.POSITIVE_INFINITY;
                matrixFast[j][k]=Double.POSITIVE_INFINITY;
                matrixFast[k][j]=Double.POSITIVE_INFINITY;
            }
        }//created the initial way of showing dijkstra's matrix -> so I can solve it
        //end new
        for(int i=0;i<p.getNoRoads();i++){
            //that whole thing is just the index of the name of the location object A or B (first or second)
            matrix[help.indexOf(p.getRoads(i).getA().getNameLocation())][help.indexOf(p.getRoads(i).getB().getNameLocation())]=1;
            matrix[help.indexOf(p.getRoads(i).getB().getNameLocation())][help.indexOf(p.getRoads(i).getA().getNameLocation())]=1;
            //new
            matrixLength[help.indexOf(p.getRoads(i).getA().getNameLocation())][help.indexOf(p.getRoads(i).getB().getNameLocation())]=p.getRoads(i).getLength();
            matrixFast[help.indexOf(p.getRoads(i).getA().getNameLocation())][help.indexOf(p.getRoads(i).getB().getNameLocation())]=p.getRoads(i).getLength()*p.getRoads(i).getSpeed();
            matrixLength[help.indexOf(p.getRoads(i).getB().getNameLocation())][help.indexOf(p.getRoads(i).getA().getNameLocation())]=p.getRoads(i).getLength();
            matrixFast[help.indexOf(p.getRoads(i).getB().getNameLocation())][help.indexOf(p.getRoads(i).getA().getNameLocation())]=p.getRoads(i).getLength()*p.getRoads(i).getSpeed();
            //end new
        }
        solve(p);
    }
}
