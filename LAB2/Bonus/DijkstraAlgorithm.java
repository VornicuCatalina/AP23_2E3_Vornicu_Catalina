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
        matrixLength=new double[p.getNoLocation()+1][p.getNoLocation()+1];
        matrixFast=new double[p.getNoLocation()+1][p.getNoLocation()+1];
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
            int row=help.indexOf(p.getRoads(i).getA().getNameLocation());
            // it is used to reach the name of the location A , then look through the arraylist to get its index
            int column=help.indexOf(p.getRoads(i).getB().getNameLocation());
            // it is used to reach the name of the location A , then look through the arraylist to get its index
            //both indexes will be used to build the matrices that will be used for: 1. existent paths between 2 locations; 2. length ; 3. fastest way
            double calculatedLength=p.getRoads(i).getLength(); //just assign the value of the attribute length from the class Roads
            double calculatedTime=p.getRoads(i).getLength()/p.getRoads(i).getSpeed(); //assigns the calculated time which uses the formula: d/s ,
            //where d is distance and s is speed
            matrix[row][column]=1;
            matrix[row][column]=1;
            //new
            matrixLength[row][column]=calculatedLength;
            matrixFast[row][column]=calculatedTime;
            matrixLength[row][column]=calculatedLength;
            matrixFast[row][column]=calculatedTime;
            //end new

            /*
            For not wasting the resources ,it is much easier to declare a variable that can store the value that we need (if we use it plenty of times
            ,once declared we do not have to go through all of those steps just to reach the result that we have been looking for
            It is a more efficient way of handling memory access , so we do not have to access it over and over again
            The program becomes way faster than before by applying this way of accessing attributed that are in a class,
            way better if it is a subclass -> easier to handle the resources
             */
        }
        solve(p);
    }
}
